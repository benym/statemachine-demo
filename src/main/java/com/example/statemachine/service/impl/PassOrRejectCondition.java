package com.example.statemachine.service.impl;

import com.alibaba.cola.statemachine.Condition;
import com.example.statemachine.pojo.context.AuditContext;
import org.springframework.stereotype.Component;

/**
 * 通用通过/驳回条件
 * 覆盖审核正向流程，以及驳回流程
 * 已申请->爸爸同意->妈妈同意
 * 已申请->爸爸不同意
 * 爸爸同意->妈妈不同意
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
