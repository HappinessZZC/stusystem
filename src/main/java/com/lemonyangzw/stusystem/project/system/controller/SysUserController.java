package com.lemonyangzw.stusystem.project.system.controller;

import com.github.pagehelper.PageInfo;
import com.lemonyangzw.stusystem.common.constant.UserConstants;
import com.lemonyangzw.stusystem.common.utils.JsonUtils;
import com.lemonyangzw.stusystem.common.utils.SecurityUtils;
import com.lemonyangzw.stusystem.common.utils.StringUtils;
import com.lemonyangzw.stusystem.framework.web.domain.AjaxResult;
import com.lemonyangzw.stusystem.project.system.domain.SysUser;
import com.lemonyangzw.stusystem.project.system.service.SysPostService;
import com.lemonyangzw.stusystem.project.system.service.SysRoleService;
import com.lemonyangzw.stusystem.project.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Yang
 * @date 2020/11/9 9:24
 */
@Api("用户查询")
@RestController
@RequestMapping("/system/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPostService sysPostService;

    /**
     * 根据用户编号获取详细信息
     */
    @GetMapping(value = {"/", "/{userId}"})
    public AjaxResult getInfo(@PathVariable(value = "userId", required = false) Long userId) {
        AjaxResult ajax = AjaxResult.success();
        ajax.put("roles", sysRoleService.getRoleAll());
        ajax.put("posts", sysPostService.getPostAll());
//        if (StringUtils.isNotNull(userId))
//        {
//            ajax.put(AjaxResult.DATA_TAG, userService.selectUserById(userId));
//            ajax.put("postIds", sysRoleService.selectPostListByUserId(userId));
//            ajax.put("roleIds", sysPostService.selectRoleListByUserId(userId));
//        }
        return ajax;
    }

    /**
     * 新增用户
     */
    @PostMapping
    public AjaxResult add(@RequestBody SysUser user) {
        if (UserConstants.NOT_UNIQUE.equals(sysUserService.checkUserNameUnique(user.getUserName()))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(sysUserService.checkPhoneUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(sysUserService.checkEmailUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        user.setCreateBy(SecurityUtils.getUsername());
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        return AjaxResult.toAjax(sysUserService.insertUser(user));
    }

    @ApiOperation("用户列表")
    @GetMapping(value = "/getUserInfoList", produces = "application/json;charset=UTF-8")
    public String getUserInfoList() {
        return JsonUtils.toJsonString(new PageInfo(sysUserService.getUserAll()));
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds) {
        Map hashMap = new HashMap() {{
            put("1", "1");
        }};
        return AjaxResult.toAjax(sysUserService.deleteUserByIds(userIds));
    }

}

