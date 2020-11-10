package com.lemonyangzw.stusystem.project.system.mapper;

import com.lemonyangzw.stusystem.project.system.domain.SysMenu;

import java.util.List;

public interface SysMenuMapper {

    /***
     *
     * @return 全部的菜单项
     */
    List<SysMenu> selectMenuTreeAll();

    List<SysMenu> selectMenuTreeByUserId(Long userId);

    List<String> selectMenuPermsByUserId(Long userId);
}