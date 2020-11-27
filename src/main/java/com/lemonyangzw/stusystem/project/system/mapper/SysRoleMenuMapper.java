package com.lemonyangzw.stusystem.project.system.mapper;

import com.lemonyangzw.stusystem.project.system.domain.SysRoleMenu;

import java.util.List;

/**
 * @author Yang
 * @date 2020/11/25 16:06
 */
public interface SysRoleMenuMapper {
    /**
     * 批量新增角色菜单信息
     *
     * @param roleMenuList 角色菜单列表
     * @return 结果
     */
    int batchRoleMenu(List<SysRoleMenu> roleMenuList);

}