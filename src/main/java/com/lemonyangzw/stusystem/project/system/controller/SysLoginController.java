package com.lemonyangzw.stusystem.project.system.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.lemonyangzw.stusystem.common.exception.UserPasswordNotMatchException;
import com.lemonyangzw.stusystem.common.utils.JsonUtils;
import com.lemonyangzw.stusystem.framework.web.domain.AjaxResult;
import com.lemonyangzw.stusystem.framework.security.service.SysLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Yang
 * @date 2020/7/13 16:02
 */
@Api("系统登录")
//@CrossOrigin(origins = "http://localhost:9528", maxAge = 3600)
@RestController
public class SysLoginController {
    @Autowired
    public SysLoginService sysLoginService;

    /**
     *
     * @param map key:username,password,token
     * @return
     */
    @ApiOperation("登录验证")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody Map<String, String> map) {
        AjaxResult ajax = AjaxResult.success();
        try{
            throw new Exception();
        }catch (Exception e){
            throw new UserPasswordNotMatchException();
        }
//        String token = sysLoginService.login(map);
//        ajax.put("token", token);
//        return ajax;
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/getInfo")
    public AjaxResult getInfo(){
        AjaxResult ajax = AjaxResult.success();
        // 角色集合
        Set<String> roles = new HashSet<String>();
        roles.add("admin");
        ajax.put("user", JsonUtils.string2Obj("{\"username\": \"123\"}", JsonNode.class));
        ajax.put("roles",roles);
        ajax.put("permissions", roles);
        System.out.println("123");
        return ajax;
    }

}
