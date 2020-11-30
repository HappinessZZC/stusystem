package com.lemonyangzw.stusystem.project.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.lemonyangzw.stusystem.framework.web.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门表
 *
 * @author Yang
 * @date 2020/11/30 9:08
 */
@TableName(value = "sys_dept")
public class SysDept extends BaseEntity {
    public static final String COL_DEPT_ID = "dept_id";
    public static final String COL_PARENT_ID = "parent_id";
    public static final String COL_ANCESTORS = "ancestors";
    public static final String COL_DEPT_NAME = "dept_name";
    public static final String COL_ORDER_NUM = "order_num";
    public static final String COL_LEADER = "leader";
    public static final String COL_PHONE = "phone";
    public static final String COL_EMAIL = "email";
    public static final String COL_STATUS = "status";
    public static final String COL_DEL_FLAG = "del_flag";
    /**
     * 部门id
     */
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long deptId;
    /**
     * 父部门id
     */
    @TableField(value = "parent_id")
    private Long parentId;
    /**
     * 祖级列表
     */
    @TableField(value = "ancestors")
    private String ancestors;
    /**
     * 部门名称
     */
    @TableField(value = "dept_name")
    private String deptName;
    /**
     * 显示顺序
     */
    @TableField(value = "order_num")
    private Integer orderNum;
    /**
     * 负责人
     */
    @TableField(value = "leader")
    private String leader;
    /**
     * 联系电话
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;
    /**
     * 部门状态（0正常 1停用）
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
     * 子部门
     */
    @TableField(exist = false)
    private List<SysDept> children = new ArrayList<>();

    /**
     * 获取部门id
     *
     * @return dept_id - 部门id
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取父部门id
     *
     * @return parent_id - 父部门id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父部门id
     *
     * @param parentId 父部门id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取祖级列表
     *
     * @return ancestors - 祖级列表
     */
    public String getAncestors() {
        return ancestors;
    }

    /**
     * 设置祖级列表
     *
     * @param ancestors 祖级列表
     */
    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    /**
     * 获取部门名称
     *
     * @return dept_name - 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置部门名称
     *
     * @param deptName 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
     * 获取负责人
     *
     * @return leader - 负责人
     */
    public String getLeader() {
        return leader;
    }

    /**
     * 设置负责人
     *
     * @param leader 负责人
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取部门状态（0正常 1停用）
     *
     * @return status - 部门状态（0正常 1停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置部门状态（0正常 1停用）
     *
     * @param status 部门状态（0正常 1停用）
     */
    public void setStatus(String status) {
        this.status = status;
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
     * @param delFlag 删除标志（0代表存在 2代表删除）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public List<SysDept> getChildren() {
        return children;
    }

    public void setChildren(List<SysDept> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptId=").append(deptId);
        sb.append(", parentId=").append(parentId);
        sb.append(", ancestors=").append(ancestors);
        sb.append(", deptName=").append(deptName);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", leader=").append(leader);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", status=").append(status);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}