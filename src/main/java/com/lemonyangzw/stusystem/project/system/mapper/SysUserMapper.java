package com.lemonyangzw.stusystem.project.system.mapper;

import com.lemonyangzw.stusystem.project.system.domain.SysUser;

import java.util.List;

public interface SysUserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysUser selectUserByUserName(String username);

    /**
     * 查询全部的用户信息
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    int checkUserNameUnique(String userName);

    /**
     * 校验手机号码是否唯一
     *
     * @param phonenumber 手机号码
     * @return 结果
     */
    SysUser checkPhoneUnique(String phonenumber);

    /**
     * 校验email是否唯一
     *
     * @param email 用户邮箱
     * @return 结果
     */
    SysUser checkEmailUnique(String email);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int insertUser(SysUser user);

    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的用户ID
     * @return 结果
     */
    int deleteUserByIds(Long[] userIds);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    SysUser selectUserById(Long userId);
}