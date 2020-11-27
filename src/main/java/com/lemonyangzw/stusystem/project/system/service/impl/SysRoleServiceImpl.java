package com.lemonyangzw.stusystem.project.system.service.impl;

import com.lemonyangzw.stusystem.common.constant.UserConstants;
import com.lemonyangzw.stusystem.common.utils.PageUtils;
import com.lemonyangzw.stusystem.common.utils.StringUtils;
import com.lemonyangzw.stusystem.project.system.domain.SysRole;
import com.lemonyangzw.stusystem.project.system.domain.SysRoleMenu;
import com.lemonyangzw.stusystem.project.system.mapper.SysRoleMapper;
import com.lemonyangzw.stusystem.project.system.mapper.SysRoleMenuMapper;
import com.lemonyangzw.stusystem.project.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Yang
 * @date 2020/11/5 9:49
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 根据用户ID获取角色
     *
     * @param userId
     * @return List<SysRole>
     */
    @Override
    public List<SysRole> getSysRoleByUserId(Long userId) {
        return sysRoleMapper.selectByUserId(userId);
    }

    /**
     * 获取全部的用户角色
     *
     * @return List<SysRole>
     */
    @Override
    public List<SysRole> getRoleAll() {
        return sysRoleMapper.getRoleAll();
    }

    /**
     * 根据用户ID获取角色选择框列表
     *
     * @param userId 用户ID
     * @return 选中角色ID列表
     */
    public List<Integer> selectRoleListByUserId(Long userId) {
        return sysRoleMapper.selectRoleListByUserId(userId);
    }

    /**
     * 根据条件分页查询角色数据
     *
     * @param role 角色信息
     * @return 角色数据集合信息
     */
    @Override
    public List<SysRole> selectRoleList(SysRole role) {
        PageUtils.startPageByRequest();
        return sysRoleMapper.selectRoleList(role);
    }

    /**
     * 校验角色名称是否唯一
     *
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public String checkRoleNameUnique(SysRole role) {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = sysRoleMapper.checkRoleNameUnique(role.getRoleName());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验角色权限是否唯一
     *
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public String checkRoleKeyUnique(SysRole role) {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = sysRoleMapper.checkRoleKeyUnique(role.getRoleKey());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 新增保存角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertRole(SysRole role) {
        // 新增角色信息
        sysRoleMapper.insertRole(role);
        return insertRoleMenu(role);
    }

    /**
     * 新增角色菜单信息
     *
     * @param role 角色对象
     */
    public int insertRoleMenu(SysRole role) {
        int rows = 1;
        // 新增用户与角色管理
        List<SysRoleMenu> list = new ArrayList<>();
        for (Long menuId : role.getMenuIds()) {
            SysRoleMenu rm = new SysRoleMenu();
            rm.setRoleId(role.getRoleId());
            rm.setMenuId(menuId);
            list.add(rm);
        }
        if (list.size() > 0) {
            rows = sysRoleMenuMapper.batchRoleMenu(list);
        }
        return rows;
    }
}
