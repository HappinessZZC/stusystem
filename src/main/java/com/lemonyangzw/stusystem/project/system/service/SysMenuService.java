package com.lemonyangzw.stusystem.project.system.service;

import com.lemonyangzw.stusystem.project.system.domain.SysMenu;
import com.lemonyangzw.stusystem.project.system.domain.TreeSelect;
import com.lemonyangzw.stusystem.project.system.domain.vo.RouterVo;

import java.util.List;
import java.util.Set;

/**
 * @author Yang
 * @date 2020/11/5 9:16
 */
public interface SysMenuService {
    /**
     * 根据用户ID查询菜单树(导航展示菜单)
     *
     * @param userId 用户名称
     * @return 菜单列表
     */
    List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 构建前端路由所需要的菜单
     *
     * @param menus 菜单列表
     * @return 路由列表
     */
    List<RouterVo> buildMenus(List<SysMenu> menus);

    /**
     * 根据用户ID获取菜单权限
     *
     * @param userId 用户ID
     * @return Set<String>
     */
    Set<String> selectMenuPermsssionByUserId(Long userId);

    /**
     * 根据用户查询系统菜单列表(包括按钮)
     *
     * @param menu   菜单信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<SysMenu> selectMenuList(SysMenu menu, Long userId);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param menus 菜单列表
     * @return 下拉树结构列表
     */
    List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus);
}
