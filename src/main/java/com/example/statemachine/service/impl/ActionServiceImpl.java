package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Action;
import com.example.statemachine.pojo.context.AuditContext;
import com.example.statemachine.pojo.event.AuditEvent;
import com.example.statemachine.pojo.state.AuditState;
import com.example.statemachine.service.ActionService;
import org.springframework.stereotype.Component;

/**
 * @author benym
 * @date 2023/7/12 17:50
 */
@Component
public class ActionServiceImpl implements ActionService {
    @Override
    public Action<AuditState, AuditEvent, AuditContext> passOrRejectAction() {
        return (from, to, event, context) -> {

        };
    }

    @Override
    public Action<AuditState, AuditEvent, AuditContext> closeAction() {
        return (from, to, event, context) -> {

        };
    }
}
