package com.lemonyangzw.stusystem.project.system.service;

import com.lemonyangzw.stusystem.project.system.domain.SysRole;

import java.util.List;

/**
 * @author Yang
 * @date 2020/11/5 9:29
 */
public interface SysRoleService {
    List<SysRole> getSysRoleByUserId(Long id);

}
