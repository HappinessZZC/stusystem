package com.lemonyangzw.stusystem.project.system.controller;

import com.github.pagehelper.PageInfo;
import com.lemonyangzw.stusystem.common.utils.JsonUtils;
import com.lemonyangzw.stusystem.project.system.domain.SysUser;
import com.lemonyangzw.stusystem.project.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang
 * @date 2020/11/9 9:24
 */
@Api("用户查询")
@RestController
@RequestMapping("/system/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserServicel;

    @ApiOperation("用户列表")
    @GetMapping(value = "/getUserInfoList",produces = "application/json;charset=UTF-8")
    public String getUserInfoList(){
        return JsonUtils.toJsonString(new PageInfo(sysUserServicel.getUserAll()));
    }
}

