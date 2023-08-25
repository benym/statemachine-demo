package com.example.statemachine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.statemachine.pojo.domain.AuditDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author benym
 * @date 2023/7/12 16:42
 */
@Mapper
public interface AuditMapper extends BaseMapper<AuditDO> {

}
