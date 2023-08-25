package com.example.statemachine.dao;

import com.example.statemachine.pojo.dto.AuditDTO;

/**
 * @author benym
 * @date 2023/7/12 16:42
 */
public interface AuditDao {

    AuditDTO selectById(Long id);

    void updateAuditStatus(String auditStatus, Long id);
}
