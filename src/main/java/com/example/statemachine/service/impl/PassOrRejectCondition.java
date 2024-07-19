package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.pojo.context.AuditContext;
import org.springframework.stereotype.Component;

/**
 * 已完成条件
 *
 * @author benym
 * @date 2024/7/19 11:44
 */
@Component
public class PassOrRejectCondition implements Condition<AuditContext> {

    @Override
    public boolean isSatisfied(AuditContext context) {
        System.out.println(1);
        return true;
    }
}
