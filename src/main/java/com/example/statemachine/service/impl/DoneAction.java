package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Action;
import com.example.statemachine.dao.AuditDao;
import com.example.statemachine.pojo.context.AuditContext;
import com.example.statemachine.pojo.event.AuditEvent;
import com.example.statemachine.pojo.state.AuditState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 已完成执行动作
 *
 * @author benym
 * @date 2024/7/19 11:40
 */
@Component
public class DoneAction implements Action<AuditState, AuditEvent, AuditContext> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoneAction.class);

    @Autowired
    private AuditDao auditDao;

    @Override
    public void execute(AuditState from, AuditState to, AuditEvent event, AuditContext context) {
        LOGGER.info("doneAction from {}, to {}, on event {}, id:{}", from, to, event, context.getId());
        auditDao.updateAuditStatus(to.getCode(), context.getId());
    }
}
