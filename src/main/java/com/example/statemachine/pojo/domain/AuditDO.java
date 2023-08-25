package com.example.statemachine.pojo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author benym
 * @date 2023/7/12 16:23
 */
@Data
@TableName("audit")
public class AuditDO {

    @TableId
    private Long id;

    @TableField(value = "audit_state")
    private String auditState;
}
