package com.lemonyangzw.stusystem.project.system.service.impl;

import com.lemonyangzw.stusystem.project.system.domain.SysRole;
import com.lemonyangzw.stusystem.project.system.mapper.SysRoleMapper;
import com.lemonyangzw.stusystem.project.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Yang
 * @date 2020/11/5 9:49
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysroleMapper;
    /**
     * 根据用户ID获取角色
     * @param userId
     * @return List<SysRole>
     */
    @Override
    public List<SysRole> getSysRoleByUserId(Long userId) {
        return sysroleMapper.selectByUserId(userId);
    }

    /**
     * 获取全部的用户角色
     * @return List<SysRole>
     */
    @Override
    public List<SysRole> getRoleAll() {
        return sysroleMapper.getRoleAll();
    }
    /**
     * 根据用户ID获取角色选择框列表
     *
     * @param userId 用户ID
     * @return 选中角色ID列表
     */
    public List<Integer> selectRoleListByUserId(Long userId)
    {
        return sysroleMapper.selectRoleListByUserId(userId);
    }
}
