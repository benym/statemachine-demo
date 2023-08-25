package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.pojo.context.AuditContext;
import com.example.statemachine.service.ConditionService;
import org.springframework.stereotype.Component;

/**
 * @author benym
 * @date 2023/7/12 17:50
 */
@Component
public class ConditionServiceImpl implements ConditionService {
    @Override
    public Condition<AuditContext> passOrRejectCondition() {
        return context -> {
            System.out.println(1);
            return true;
        };
    }

    @Override
    public Condition<AuditContext> doneCondition() {
        return context -> {
            System.out.println(1);
            return true;
        };
    }
}
