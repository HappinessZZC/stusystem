package com.lemonyangzw.stusystem.project.system.controller;

import com.github.pagehelper.PageInfo;
import com.lemonyangzw.stusystem.common.constant.UserConstants;
import com.lemonyangzw.stusystem.common.utils.JsonUtils;
import com.lemonyangzw.stusystem.common.utils.SecurityUtils;
import com.lemonyangzw.stusystem.framework.web.domain.AjaxResult;
import com.lemonyangzw.stusystem.project.system.domain.SysRole;
import com.lemonyangzw.stusystem.project.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制
 *
 * @author Yang
 * @date 2020/11/24 14:31
 */
@RestController
@RequestMapping("/system/role")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 角色列表
     *
     * @param role
     * @return
     */
    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public String list(SysRole role) {
        return JsonUtils.toJsonString(new PageInfo(sysRoleService.selectRoleList(role)));
    }

    /**
     * 新增角色
     */
    @PostMapping
    public AjaxResult add(@RequestBody SysRole role) {
        if (UserConstants.NOT_UNIQUE.equals(sysRoleService.checkRoleNameUnique(role))) {
            return AjaxResult.error("新增角色'" + role.getRoleName() + "'失败，角色名称已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(sysRoleService.checkRoleKeyUnique(role))) {
            return AjaxResult.error("新增角色'" + role.getRoleName() + "'失败，角色权限已存在");
        }
        role.setCreateBy(SecurityUtils.getUsername());
        return AjaxResult.toAjax(sysRoleService.insertRole(role));

    }
}
