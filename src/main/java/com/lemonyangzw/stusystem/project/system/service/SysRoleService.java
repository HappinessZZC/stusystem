package com.lemonyangzw.stusystem.project.system.service;

import com.lemonyangzw.stusystem.project.system.domain.SysRole;

import java.util.List;

/**
 * @author Yang
 * @date 2020/11/5 9:29
 */
public interface SysRoleService {
    /**
     * 根据用户ID获取角色
     * @param id
     * @return List<SysRole>
     */
    List<SysRole> getSysRoleByUserId(Long id);

}
