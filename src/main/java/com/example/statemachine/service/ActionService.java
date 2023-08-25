package com.example.statemachine.service;

import com.alibaba.cola.statemachine.Action;
import com.example.statemachine.pojo.context.AuditContext;
import com.example.statemachine.pojo.event.AuditEvent;
import com.example.statemachine.pojo.state.AuditState;

/**
 * @author benym
 * @date 2023/7/12 17:47
 */
public interface ActionService {

    /**
     * 通用审核通过/驳回执行动作
     * 覆盖审核正向流程，以及驳回流程
     * 已申请->爸爸同意->妈妈同意
     * 已申请->爸爸不同意
     * 爸爸同意->妈妈不同意
     *
     * @return Action
     */
    Action<AuditState, AuditEvent, AuditContext> passOrRejectAction();

    /**
     * 已完成执行动作
     *
     * @return Action
     */
    Action<AuditState, AuditEvent, AuditContext> doneAction();
}
