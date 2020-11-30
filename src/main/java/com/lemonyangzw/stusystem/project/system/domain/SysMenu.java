package com.lemonyangzw.stusystem.project.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lemonyangzw.stusystem.framework.web.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang
 * @date 2020/11/30 9:21
 */

/**
 * 菜单权限表
 */
@TableName(value = "sys_menu")
public class SysMenu extends BaseEntity {
    public static final String COL_MENU_ID = "menu_id";
    public static final String COL_MENU_NAME = "menu_name";
    public static final String COL_PARENT_ID = "parent_id";
    public static final String COL_ORDER_NUM = "order_num";
    public static final String COL_PATH = "path";
    public static final String COL_COMPONENT = "component";
    public static final String COL_IS_FRAME = "is_frame";
    public static final String COL_MENU_TYPE = "menu_type";
    public static final String COL_VISIBLE = "visible";
    public static final String COL_STATUS = "status";
    public static final String COL_PERMS = "perms";
    public static final String COL_ICON = "icon";
    public static final String COL_REMARK = "remark";
    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;
    /**
     * 菜单名称
     */
    @TableField(value = "menu_name")
    private String menuName;
    /**
     * 父菜单ID
     */
    @TableField(value = "parent_id")
    private Long parentId;
    /**
     * 显示顺序
     */
    @TableField(value = "order_num")
    private Integer orderNum;
    /**
     * 路由地址
     */
    @TableField(value = "`path`")
    private String path;
    /**
     * 组件路径
     */
    @TableField(value = "component")
    private String component;
    /**
     * 是否为外链（0是 1否）
     */
    @TableField(value = "is_frame")
    private Integer isFrame;
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @TableField(value = "menu_type")
    private String menuType;
    /**
     * 菜单状态（0显示 1隐藏）
     */
    @TableField(value = "visible")
    private String visible;
    /**
     * 菜单状态（0正常 1停用）
     */
    @TableField(value = "`status`")
    private String status;
    /**
     * 权限标识
     */
    @TableField(value = "perms")
    private String perms;
    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;
    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;
    /** 子菜单 */
    @TableField(exist = false)
    private List<SysMenu> children = new ArrayList<>();

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

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取父菜单ID
     *
     * @return parent_id - 父菜单ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单ID
     *
     * @param parentId 父菜单ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取显示顺序
     *
     * @return order_num - 显示顺序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置显示顺序
     *
     * @param orderNum 显示顺序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取路由地址
     *
     * @return path - 路由地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置路由地址
     *
     * @param path 路由地址
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取组件路径
     *
     * @return component - 组件路径
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置组件路径
     *
     * @param component 组件路径
     */
    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    /**
     * 获取是否为外链（0是 1否）
     *
     * @return is_frame - 是否为外链（0是 1否）
     */
    public Integer getIsFrame() {
        return isFrame;
    }

    /**
     * 设置是否为外链（0是 1否）
     *
     * @param isFrame 是否为外链（0是 1否）
     */
    public void setIsFrame(Integer isFrame) {
        this.isFrame = isFrame;
    }

    /**
     * 获取菜单类型（M目录 C菜单 F按钮）
     *
     * @return menu_type - 菜单类型（M目录 C菜单 F按钮）
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型（M目录 C菜单 F按钮）
     *
     * @param menuType 菜单类型（M目录 C菜单 F按钮）
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    /**
     * 获取菜单状态（0显示 1隐藏）
     *
     * @return visible - 菜单状态（0显示 1隐藏）
     */
    public String getVisible() {
        return visible;
    }

    /**
     * 设置菜单状态（0显示 1隐藏）
     *
     * @param visible 菜单状态（0显示 1隐藏）
     */
    public void setVisible(String visible) {
        this.visible = visible == null ? null : visible.trim();
    }

    /**
     * 获取菜单状态（0正常 1停用）
     *
     * @return status - 菜单状态（0正常 1停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置菜单状态（0正常 1停用）
     *
     * @param status 菜单状态（0正常 1停用）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取权限标识
     *
     * @return perms - 权限标识
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 设置权限标识
     *
     * @param perms 权限标识
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * 获取菜单图标
     *
     * @return icon - 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单图标
     *
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuId=").append(menuId);
        sb.append(", menuName=").append(menuName);
        sb.append(", parentId=").append(parentId);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", path=").append(path);
        sb.append(", component=").append(component);
        sb.append(", isFrame=").append(isFrame);
        sb.append(", menuType=").append(menuType);
        sb.append(", visible=").append(visible);
        sb.append(", status=").append(status);
        sb.append(", perms=").append(perms);
        sb.append(", icon=").append(icon);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}