package com.lemonyangzw.stusystem.project.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.lemonyangzw.stusystem.framework.web.domain.BaseEntity;

/**
 * 角色信息表
 *
 * @author Yang
 * @date 2020/11/30 9:30
 */

@TableName(value = "sys_role")
public class SysRole extends BaseEntity {
    public static final String COL_CREATE_BY = "create_by";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_UPDATE_BY = "update_by";
    public static final String COL_UPDATE_TIME = "update_time";
    public static final String COL_ROLE_ID = "role_id";
    public static final String COL_ROLE_NAME = "role_name";
    public static final String COL_ROLE_KEY = "role_key";
    public static final String COL_ROLE_SORT = "role_sort";
    public static final String COL_DATA_SCOPE = "data_scope";
    public static final String COL_STATUS = "status";
    public static final String COL_DEL_FLAG = "del_flag";
    public static final String COL_REMARK = "remark";
    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;
    /**
     * 角色名称
     */
    @TableField(value = "role_name")
    private String roleName;
    /**
     * 角色权限字符串
     */
    @TableField(value = "role_key")
    private String roleKey;
    /**
     * 显示顺序
     */
    @TableField(value = "role_sort")
    private Integer roleSort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @TableField(value = "data_scope")
    private String dataScope;
    /**
     * 角色状态（0正常 1停用）
     */
    @TableField(value = "`status`")
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableField(value = "del_flag")
    @TableLogic
    private String delFlag;
    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;
    /**
     * 用户是否存在此角色标识 默认不存在
     */
    @TableField(exist = false)
    private boolean flag = false;
    /**
     * 菜单组
     */
    @TableField(exist = false)
    private Long[] menuIds;
    /**
     * 部门组（数据权限）
     */
    @TableField(exist = false)
    private Long[] deptIds;

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
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取角色权限字符串
     *
     * @return role_key - 角色权限字符串
     */
    public String getRoleKey() {
        return roleKey;
    }

    /**
     * 设置角色权限字符串
     *
     * @param roleKey 角色权限字符串
     */
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey == null ? null : roleKey.trim();
    }

    /**
     * 获取显示顺序
     *
     * @return role_sort - 显示顺序
     */
    public Integer getRoleSort() {
        return roleSort;
    }

    /**
     * 设置显示顺序
     *
     * @param roleSort 显示顺序
     */
    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    /**
     * 获取数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     *
     * @return data_scope - 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    public String getDataScope() {
        return dataScope;
    }

    /**
     * 设置数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     *
     * @param dataScope 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    public void setDataScope(String dataScope) {
        this.dataScope = dataScope == null ? null : dataScope.trim();
    }

    /**
     * 获取角色状态（0正常 1停用）
     *
     * @return status - 角色状态（0正常 1停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置角色状态（0正常 1停用）
     *
     * @param status 角色状态（0正常 1停用）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取删除标志（0代表存在 2代表删除）
     *
     * @return del_flag - 删除标志（0代表存在 2代表删除）
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标志（0代表存在 2代表删除）
     *
     * @param flag 删除标志（0代表存在 2代表删除）
     */
    public void setDelFlag(boolean flag) {
        this.flag = flag;
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

    public Long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds) {
        this.menuIds = menuIds;
    }

    public Long[] getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(Long[] deptIds) {
        this.deptIds = deptIds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleKey=").append(roleKey);
        sb.append(", roleSort=").append(roleSort);
        sb.append(", dataScope=").append(dataScope);
        sb.append(", status=").append(status);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}