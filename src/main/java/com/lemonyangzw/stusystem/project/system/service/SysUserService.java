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
    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    String checkUserNameUnique(String userName);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    String checkPhoneUnique(SysUser user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    String checkEmailUnique(SysUser user);
    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int insertUser(SysUser user);
}
