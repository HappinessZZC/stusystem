package com.lemonyangzw.stusystem.project.system.service;

import com.lemonyangzw.stusystem.project.system.domain.SysMenu;
import com.lemonyangzw.stusystem.project.system.domain.vo.RouterVo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Yang
 * @date 2020/11/5 9:16
 */
public interface SysMenuService {
    List<SysMenu> selectMenuTreeByUserId(Long userId);

    List<RouterVo> buildMenus(List<SysMenu> menus);

    Set<String> selectMenuPermsssionByUserId(Long userId);
}
