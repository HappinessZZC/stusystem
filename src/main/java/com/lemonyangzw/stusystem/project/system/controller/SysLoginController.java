package com.lemonyangzw.stusystem.project.system.controller;

import com.lemonyangzw.stusystem.common.utils.StringUtils;
import com.lemonyangzw.stusystem.common.utils.TokenUtils;
import com.lemonyangzw.stusystem.framework.security.LoginBody;
import com.lemonyangzw.stusystem.framework.security.LoginUser;
import com.lemonyangzw.stusystem.framework.security.service.SysLoginService;
import com.lemonyangzw.stusystem.framework.web.domain.AjaxResult;
import com.lemonyangzw.stusystem.project.system.domain.SysMenu;
import com.lemonyangzw.stusystem.project.system.domain.SysRole;
import com.lemonyangzw.stusystem.project.system.domain.SysUser;
import com.lemonyangzw.stusystem.project.system.service.SysMenuService;
import com.lemonyangzw.stusystem.project.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
    private SysLoginService sysLoginService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private SysRoleService sysRoleService;


    @ApiOperation("登录验证")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        String token = sysLoginService.login(loginBody.getUsername(), loginBody.getPassword(),
                loginBody.getUuid());
        ajax.put("token", token);
        return ajax;
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/getInfo")
    public AjaxResult getInfo(HttpServletRequest request) {
        SysUser user = tokenUtils.getLoginUser(request).getUser();
        AjaxResult ajax = AjaxResult.success();
        // 角色集合
        List<SysRole> sysRoles = sysRoleService.getSysRoleByUserId(user.getUserId());
        Set<String> roles = new HashSet<>();
        for (SysRole sysRole : sysRoles) {
            if (StringUtils.isNotNull(sysRole)) {
                roles.addAll(Arrays.asList(sysRole.getRoleKey().trim().split(",")));
            }
        }
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", roles);
        return ajax;
    }

    @ApiOperation("获取路由信息")
    @GetMapping("getRouters")
    public AjaxResult getRouters(HttpServletRequest request) {
        LoginUser loginUser = tokenUtils.getLoginUser(request);
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> menus = sysMenuService.selectMenuTreeByUserId(user.getUserId());
        return AjaxResult.success(sysMenuService.buildMenus(menus));
    }

}
