package com.lemonyangzw.stusystem.project.system.service;

import com.lemonyangzw.stusystem.project.system.domain.SysUser;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.List;

/**
 * @author Yang
 * @date 2020/9/10 14:20
 */

public interface SysUserService {
    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return SysUser 用户
     */
    SysUser selectUserByUserName(String username);

    /**
     * 获取全部的用户
     * @return List<SysUser>
     */
    List<SysUser> getUserAll();
}
