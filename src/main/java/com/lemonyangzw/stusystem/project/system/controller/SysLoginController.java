package com.lemonyangzw.stusystem.project.system.controller;

import com.lemonyangzw.stusystem.framework.web.domain.AjaxResult;
import com.lemonyangzw.stusystem.project.system.service.SysLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Yang
 * @date 2020/7/13 16:02
 */
@Api("系统登录")
@RestController
public class SysLoginController {
    @Autowired
    public SysLoginService sysLoginService;

    @ApiOperation("登录验证")
    @PostMapping("/login")
    @CrossOrigin("http://localhost:9528")
    public AjaxResult login(@RequestBody Map<String, String> map) {
        AjaxResult ajax = AjaxResult.success();
        String token = sysLoginService.login(map);

        ajax.put("token", token);
        return ajax;
    }


}
