package com.lemonyangzw.stusystem.project.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lemonyangzw.stusystem.framework.web.domain.BaseEntity;

/**
 * 角色和菜单关联表
 *
 * @author Yang
 * @date 2020/11/30 9:33
 */
@TableName(value = "sys_role_menu")
public class SysRoleMenu extends BaseEntity {
    public static final String COL_ROLE_ID = "role_id";
    public static final String COL_MENU_ID = "menu_id";
    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;
    /**
     * 菜单ID
     */
    @TableField("menu_id")
    private Long menuId;

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取菜单ID
     *
     * @return menu_id - 菜单ID
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单ID
     *
     * @param menuId 菜单ID
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", menuId=").append(menuId);
        sb.append("]");
        return sb.toString();
    }
}