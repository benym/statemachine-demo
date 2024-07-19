package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.pojo.context.AuditContext;
import org.springframework.stereotype.Component;

/**
 * @author yuanming3
 * @date 2024/7/19 11:30
 */
@Component
public class ConditionTest implements Condition<AuditContext> {

    @Override
    public boolean isSatisfied(AuditContext context) {
        return false;
    }
}
