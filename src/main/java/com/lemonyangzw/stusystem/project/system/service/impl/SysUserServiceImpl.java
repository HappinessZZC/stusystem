package com.lemonyangzw.stusystem.project.system.service.impl;

import com.lemonyangzw.stusystem.common.constant.UserConstants;
import com.lemonyangzw.stusystem.common.exception.CustomException;
import com.lemonyangzw.stusystem.common.utils.PageUtils;
import com.lemonyangzw.stusystem.common.utils.RoleUtils;
import com.lemonyangzw.stusystem.common.utils.StringUtils;
import com.lemonyangzw.stusystem.project.system.domain.SysUser;
import com.lemonyangzw.stusystem.project.system.domain.SysUserPost;
import com.lemonyangzw.stusystem.project.system.domain.SysUserRole;
import com.lemonyangzw.stusystem.project.system.mapper.SysUserMapper;
import com.lemonyangzw.stusystem.project.system.mapper.SysUserPostMapper;
import com.lemonyangzw.stusystem.project.system.mapper.SysUserRoleMapper;
import com.lemonyangzw.stusystem.project.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang
 * @date 2020/9/10 14:19
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysUserPostMapper sysUserPostMapper;
    @Autowired
    private RoleUtils roleUtils;

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return SysUser 用户
     */
    @Override
    public SysUser selectUserByUserName(String username) {
        return sysUserMapper.selectUserByUserName(username);
    }

    /**
     * 获取全部的用户
     *
     * @return List<SysUser>
     */
    public List<SysUser> getUserAll() {
        PageUtils.startPageByRequest();
        return sysUserMapper.selectAll();
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    @Override
    public String checkUserNameUnique(String userName) {
        int count = sysUserMapper.checkUserNameUnique(userName);
        if (count > 0) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public String checkPhoneUnique(SysUser user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = sysUserMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public String checkEmailUnique(SysUser user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = sysUserMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 新增保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertUser(SysUser user) {
        // 新增用户信息
        int rows = sysUserMapper.insertUser(user);
        // 新增用户岗位关联
        insertUserPost(user);
        // 新增用户与角色管理
        insertUserRole(user);
        return rows;
    }

    /**
     * 新增用户岗位信息
     *
     * @param user 用户对象
     */
    public void insertUserPost(SysUser user) {
        Long[] posts = user.getPostIds();
        if (StringUtils.isNotNull(posts)) {
            // 新增用户与岗位管理
            List<SysUserPost> list = new ArrayList<SysUserPost>();
            for (Long postId : posts) {
                SysUserPost up = new SysUserPost();
                up.setUserId(user.getUserId());
                up.setPostId(postId);
                list.add(up);
            }
            if (list.size() > 0) {
                sysUserPostMapper.batchUserPost(list);
            }
        }
    }

    /**
     * 新增用户角色信息
     *
     * @param user 用户对象
     */
    public void insertUserRole(SysUser user) {
        Long[] roles = user.getRoleIds();
        if (StringUtils.isNotNull(roles)) {
            // 新增用户与角色管理
            List<SysUserRole> list = new ArrayList<SysUserRole>();
            for (Long roleId : roles) {
                SysUserRole ur = new SysUserRole();
                ur.setUserId(user.getUserId());
                ur.setRoleId(roleId);
                list.add(ur);
            }
            if (list.size() > 0) {
                sysUserRoleMapper.batchUserRole(list);
            }
        }
    }

    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的用户ID
     * @return 结果
     */
    public int deleteUserByIds(Long[] userIds) {
        for (Long userId : userIds) {
            if (roleUtils.isAdmin(userId)) {
                throw new CustomException("不允许操作超级管理员用户");
            }
        }
        return sysUserMapper.deleteUserByIds(userIds);
    }

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserById(Long userId) {
        return sysUserMapper.selectUserById(userId);
    }

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    public void checkUserAllowed(SysUser user) {
        if (StringUtils.isNotNull(user.getUserId()) && roleUtils.isAdmin(user.getUserId())) {
            throw new CustomException("不允许操作超级管理员用户");
        }
    }

    /**
     * 修改保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateUser(SysUser user) {
        Long userId = user.getUserId();
        // 删除用户与角色关联
        sysUserRoleMapper.deleteUserRoleByUserId(userId);
        // 新增用户与角色管理
        insertUserRole(user);
        // 删除用户与岗位关联
        sysUserPostMapper.deleteUserPostByUserId(userId);
        // 新增用户与岗位管理
        insertUserPost(user);
        return sysUserMapper.updateUser(user);
    }

    /**
     * 修改用户状态
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUserStatus(SysUser user) {
        return sysUserMapper.updateUser(user);
    }

    /**
     * 重置用户密码
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int resetPwd(SysUser user) {
        return sysUserMapper.updateUser(user);
    }
}
