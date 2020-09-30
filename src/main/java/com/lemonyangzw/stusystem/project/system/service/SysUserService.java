package com.lemonyangzw.stusystem.project.system.service;

import com.lemonyangzw.stusystem.project.system.domain.SysUser;

/**
 * @author Yang
 * @date 2020/9/10 14:20
 */




public interface SysUserService {
    public SysUser selectUserByUserName(String username);
}
