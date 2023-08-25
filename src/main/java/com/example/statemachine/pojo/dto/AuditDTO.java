package com.example.statemachine.pojo.dto;

import lombok.Data;

/**
 * @author benym
 * @date 2023/7/12 16:22
 */
@Data
public class AuditDTO {

    private Long id;

    private String auditState;
}
