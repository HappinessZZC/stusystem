package com.lemonyangzw.stusystem.common.utils;

import com.lemonyangzw.stusystem.project.system.domain.SysRole;
import com.lemonyangzw.stusystem.project.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Yang
 * @date 2020/11/5 9:26
 */
@Component
public class RoleUtils {
    @Autowired
    private SysRoleService sysRoleService;

    /***
     * 根据用户ID查看用户是否是管理员(RoleKey : admin)
     * @param  UserId 用户ID
     * @return 角色列表
     */
    public boolean isAdmin(Long UserId){
        List<SysRole> roleList = sysRoleService.getSysRoleByUserId(UserId);
        for (SysRole sysRole : roleList) {
            if("admin".equals(sysRole.getRoleKey())){
                return true;
            }
        }
        return false;
    }
}
