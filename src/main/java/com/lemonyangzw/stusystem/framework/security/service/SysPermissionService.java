package com.lemonyangzw.stusystem.framework.security.service;

import com.lemonyangzw.stusystem.common.utils.RoleUtils;
import com.lemonyangzw.stusystem.project.system.domain.SysUser;
import com.lemonyangzw.stusystem.project.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yang
 * @date 2020/9/10 14:40
 */
@Component
public class SysPermissionService {
    @Autowired
    private RoleUtils roleUtils;

    @Autowired
    private SysMenuService sysMenuService;
    /**
     * 获取菜单数据权限
     *
     * @param user 用户信息
     * @return 菜单权限信息
     */
    public Set<String> getMenuPermission(SysUser user)
    {
        Set<String> perms = new HashSet<String>();
        if (roleUtils.isAdmin(user.getUserId()))
        {
            perms.add("*:*:*");
        }
        else
        {
            perms.addAll(sysMenuService.selectMenuPermsssionByUserId(user.getUserId()));
        }
        return perms;
    }
}
