package com.example.statemachine.controller;

import com.example.statemachine.pojo.context.AuditContext;
import com.example.statemachine.pojo.param.AuditParam;
import com.example.statemachine.service.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author benym
 * @date 2023/7/12 15:50
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private AuditService auditService;

    @PostMapping("/audit")
    public void audit(@RequestBody @Validated AuditParam auditParam){
        AuditContext auditContext = new AuditContext();
        BeanUtils.copyProperties(auditParam, auditContext);
        auditService.audit(auditContext);
    }

    @GetMapping("/uml")
    public String uml(){
        return auditService.uml();
    }
}
