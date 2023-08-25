package com.example.statemachine.impl;

import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.example.statemachine.factory.StateMachineStrategy;
import com.example.statemachine.pojo.context.AuditContext;
import com.example.statemachine.pojo.enums.StateMachineEnum;
import com.example.statemachine.pojo.event.AuditEvent;
import com.example.statemachine.pojo.state.AuditState;
import com.example.statemachine.service.ActionService;
import com.example.statemachine.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author benym
 * @date 2023/7/12 17:24
 */
@Component
public class AuditMachine implements StateMachineStrategy {

    @Autowired
    private ConditionService conditionService;

    @Autowired
    private ActionService actionService;

    @Override
    public String getMachineType() {
        return StateMachineEnum.TEST_MACHINE.getCode();
    }

    /**
     * | From(开始状态) | To(抵达状态) | Event(事件) | When(条件)            | Perform(执行动作)  |
     * | -------------- | ------------ | ----------- | --------------------- | ------------------ |
     * | 已申请      | 爸爸同意 | 审核通过    | passOrRejectCondition | passOrRejectAction |
     * | 爸爸同意    | 妈妈同意 | 审核通过    | passOrRejectCondition | passOrRejectAction |
     * | 已申请     | 爸爸不同意 | 审核驳回    | passOrRejectCondition | passOrRejectAction |
     * | 爸爸同意   | 妈妈不同意 | 审核驳回    | passOrRejectCondition | passOrRejectAction |
     * | 已申请    | 已完成状态    | 已完成        | closeCondition        | closeAction        |
     * | 爸爸同意  | 已完成状态    | 已完成        | closeCondition        | closeAction        |
     * | 妈妈同意  | 已完成状态    | 已完成        | closeCondition        | closeAction        |
     *
     * @return StateMachine stateMachine
     */
    @Bean
    public StateMachine<AuditState, AuditEvent, AuditContext> stateMachine() {
        StateMachineBuilder<AuditState, AuditEvent, AuditContext> builder = StateMachineBuilderFactory.create();
        // 已申请->爸爸同意
        builder.externalTransition().from(AuditState.APPLY).to(AuditState.DAD_PASS)
                .on(AuditEvent.PASS)
                .when(conditionService.passOrRejectCondition())
                .perform(actionService.passOrRejectAction());
        // 已申请->爸爸不同意
        builder.externalTransition().from(AuditState.APPLY).to(AuditState.DAD_REJ)
                .on(AuditEvent.REJECT)
                .when(conditionService.passOrRejectCondition())
                .perform(actionService.passOrRejectAction());
        // 爸爸同意->妈妈同意
        builder.externalTransition().from(AuditState.DAD_PASS).to(AuditState.MOM_PASS)
                .on(AuditEvent.PASS)
                .when(conditionService.passOrRejectCondition())
                .perform(actionService.passOrRejectAction());
        // 爸爸同意->妈妈不同意
        builder.externalTransition().from(AuditState.DAD_PASS).to(AuditState.MOM_REJ)
                .on(AuditEvent.REJECT)
                .when(conditionService.passOrRejectCondition())
                .perform(actionService.passOrRejectAction());
        // 已申请->已完成
        // 爸爸同意->已完成
        // 妈妈同意->已完成
        builder.externalTransitions().fromAmong(AuditState.APPLY, AuditState.DAD_PASS, AuditState.MOM_PASS)
                .to(AuditState.DONE)
                .on(AuditEvent.DONE)
                .when(conditionService.closeCondition())
                .perform(actionService.closeAction());
        return builder.build(getMachineType());
    }
}
