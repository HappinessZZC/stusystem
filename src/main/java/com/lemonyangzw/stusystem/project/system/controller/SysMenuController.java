package com.lemonyangzw.stusystem.project.system.controller;

import com.lemonyangzw.stusystem.common.utils.RequstHelper;
import com.lemonyangzw.stusystem.common.utils.TokenUtils;
import com.lemonyangzw.stusystem.framework.security.LoginUser;
import com.lemonyangzw.stusystem.framework.web.domain.AjaxResult;
import com.lemonyangzw.stusystem.project.system.domain.SysMenu;
import com.lemonyangzw.stusystem.project.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单
 *
 * @author Yang
 * @date 2020/11/25 9:32
 */
@RestController
@RequestMapping("/system/menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private TokenUtils tokenUtils;

    /**
     * 菜单下拉树
     *
     * @param menu
     * @return
     */
    @GetMapping("/treeselect")
    public AjaxResult getMenuTree(SysMenu menu) {
        LoginUser loginUser = tokenUtils.getLoginUser(RequstHelper.getRequest());
        Long userId = loginUser.getUser().getUserId();
        List<SysMenu> sysMenus = sysMenuService.selectMenuList(menu, userId);
        return AjaxResult.success(sysMenuService.buildMenuTreeSelect(sysMenus));
    }
}
