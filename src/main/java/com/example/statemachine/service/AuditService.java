package com.example.statemachine.service;

import com.example.statemachine.pojo.context.AuditContext;

/**
 * @author benym
 * @date 2023/7/12 15:53
 */

public interface AuditService {

    /**
     * 状态机执行
     *
     * @param auditContext auditContext
     */
    void audit(AuditContext auditContext);

    /**
     * 获取状态机Uml图
     *
     * @return String
     */
    String uml();

}
