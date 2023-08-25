package com.example.statemachine.pojo.param;

import lombok.Data;

/**
 * @author benym
 * @date 2023/7/12 16:13
 */
@Data
public class AuditParam {

    /**
     * id
     */
    private Long id;

    /**
     * 事件
     */
    private Integer auditEvent;
}
