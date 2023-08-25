package com.example.statemachine.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.statemachine.dao.AuditDao;
import com.example.statemachine.mapper.AuditMapper;
import com.example.statemachine.pojo.domain.AuditDO;
import com.example.statemachine.pojo.dto.AuditDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author benym
 * @date 2023/7/12 16:46
 */
@Component
public class AuditDaoImpl implements AuditDao {

    @Autowired
    private AuditMapper auditMapper;


    @Override
    public AuditDTO selectById(Long id) {
        try {
            AuditDO auditDO = auditMapper.selectById(id);
            AuditDTO auditDTO = new AuditDTO();
            BeanUtils.copyProperties(auditDO, auditDTO);
            return auditDTO;
        } catch (Exception e) {
            throw new RuntimeException("未知异常", e);
        }
    }
}
