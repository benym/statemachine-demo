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
import org.springframework.transaction.annotation.Transactional;

/**
 * 通用审核通过/驳回执行动作
 * 覆盖审核正向流程，以及驳回流程
 * 已申请->爸爸同意->妈妈同意
 * 已申请->爸爸不同意
 * 爸爸同意->妈妈不同意
 *
 * @author benym
 * @date 2024/7/19 10:46
 */
@Component
public class PassOrRejectAction implements Action<AuditState, AuditEvent, AuditContext> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PassOrRejectAction.class);

    @Autowired
    private AuditDao auditDao;

    @Override
    @Transactional
    public void execute(AuditState from, AuditState to, AuditEvent event, AuditContext context) {
        LOGGER.info("passOrRejectAction from {}, to {}, on event {}, id:{}", from, to, event, context.getId());
        auditDao.updateAuditStatus(to.getCode(), context.getId());
    }
}
