package com.example.statemachine.service.impl;

import com.example.statemachine.dao.AuditDao;
import com.example.statemachine.factory.StateMachineEngine;
import com.example.statemachine.pojo.context.AuditContext;
import com.example.statemachine.pojo.dto.AuditDTO;
import com.example.statemachine.pojo.enums.StateMachineEnum;
import com.example.statemachine.pojo.event.AuditEvent;
import com.example.statemachine.pojo.state.AuditState;
import com.example.statemachine.service.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author benym
 * @date 2023/7/12 15:56
 */
@Service
@Slf4j
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditDao auditDao;

    @Autowired
    private StateMachineEngine stateMachineEngine;

    @Override
    public void audit(AuditContext auditContext) {
        Long id = auditContext.getId();
        AuditDTO auditDTO = auditDao.selectById(id);
        String auditState = auditDTO.getAuditState();
        Integer auditEvent = auditContext.getAuditEvent();
        // 获取当前状态和事件
        AuditState nowState = AuditState.getEnumsByCode(auditState);
        AuditEvent nowEvent = AuditEvent.getEnumsByCode(auditEvent);
        // 执行状态机
        stateMachineEngine.fire(StateMachineEnum.TEST_MACHINE, nowState, nowEvent, auditContext);
    }

    @Override
    public String uml() {
        return stateMachineEngine.generateUml(StateMachineEnum.TEST_MACHINE);
    }
}
