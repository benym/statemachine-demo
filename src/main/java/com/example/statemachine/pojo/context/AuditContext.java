package com.example.statemachine.pojo.context;

import com.example.statemachine.pojo.dto.AuditDTO;
import lombok.Data;

/**
 * @author benym
 * @date 2023/7/12 15:55
 */
@Data
public class AuditContext {

    /**
     * id
     */
    private Long id;

    /**
     * auditDTO
     */
    private AuditDTO auditDTO;

    /**
     * 事件
     */
    private Integer auditEvent;
}
