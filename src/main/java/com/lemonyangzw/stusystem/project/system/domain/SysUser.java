package com.lemonyangzw.stusystem.project.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.lemonyangzw.stusystem.framework.web.domain.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 用户信息表
 *
 * @author Yang
 * @date 2020/11/30 9:40
 */
@TableName(value = "sys_user")
public class SysUser extends BaseEntity {
    public static final String COL_USER_ID = "user_id";
    public static final String COL_DEPT_ID = "dept_id";
    public static final String COL_USER_NAME = "user_name";
    public static final String COL_NICK_NAME = "nick_name";
    public static final String COL_USER_TYPE = "user_type";
    public static final String COL_EMAIL = "email";
    public static final String COL_PHONENUMBER = "phonenumber";
    public static final String COL_SEX = "sex";
    public static final String COL_AVATAR = "avatar";
    public static final String COL_PASSWORD = "password";
    public static final String COL_STATUS = "status";
    public static final String COL_DEL_FLAG = "del_flag";
    public static final String COL_LOGIN_IP = "login_ip";
    public static final String COL_LOGIN_DATE = "login_date";
    public static final String COL_REMARK = "remark";
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    /**
     * 部门ID
     */
    @TableField(value = "dept_id")
    private Long deptId;
    /**
     * 用户账号
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     * 用户昵称
     */
    @TableField(value = "nick_name")
    private String nickName;
    /**
     * 用户类型（00系统用户）
     */
    @TableField(value = "user_type")
    private String userType;
    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    private String email;
    /**
     * 手机号码
     */
    @TableField(value = "phonenumber")
    private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     */
    @TableField(value = "sex")
    private String sex;
    /**
     * 头像地址
     */
    @TableField(value = "avatar")
    private String avatar;
    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;
    /**
     * 帐号状态（0正常 1停用）
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
     * 最后登陆IP
     */
    @TableField(value = "login_ip")
    private String loginIp;
    /**
     * 最后登陆时间
     */
    @TableField(value = "login_date")
    private Date loginDate;
    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;
    /**
     * 部门对象
     */
    @TableField(exist = false)
    private SysDept dept;
    /**
     * 角色对象
     */
    @TableField(exist = false)
    private List<SysRole> roles;
    /**
     * 角色组
     */
    @TableField(exist = false)
    private Long[] roleIds;
    /**
     * 岗位组
     */
    @TableField(exist = false)
    private Long[] postIds;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取部门ID
     *
     * @return dept_id - 部门ID
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置部门ID
     *
     * @param deptId 部门ID
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取用户账号
     *
     * @return user_name - 用户账号
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户账号
     *
     * @param userName 用户账号
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取用户类型（00系统用户）
     *
     * @return user_type - 用户类型（00系统用户）
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型（00系统用户）
     *
     * @param userType 用户类型（00系统用户）
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取用户邮箱
     *
     * @return email - 用户邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户邮箱
     *
     * @param email 用户邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取手机号码
     *
     * @return phonenumber - 手机号码
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * 设置手机号码
     *
     * @param phonenumber 手机号码
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    /**
     * 获取用户性别（0男 1女 2未知）
     *
     * @return sex - 用户性别（0男 1女 2未知）
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置用户性别（0男 1女 2未知）
     *
     * @param sex 用户性别（0男 1女 2未知）
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取头像地址
     *
     * @return avatar - 头像地址
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像地址
     *
     * @param avatar 头像地址
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取帐号状态（0正常 1停用）
     *
     * @return status - 帐号状态（0正常 1停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置帐号状态（0正常 1停用）
     *
     * @param status 帐号状态（0正常 1停用）
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
     * @param delFlag 删除标志（0代表存在 2代表删除）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * 获取最后登陆IP
     *
     * @return login_ip - 最后登陆IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置最后登陆IP
     *
     * @param loginIp 最后登陆IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 获取最后登陆时间
     *
     * @return login_date - 最后登陆时间
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * 设置最后登陆时间
     *
     * @param loginDate 最后登陆时间
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
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

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds() {
        return postIds;
    }

    public void setPostIds(Long[] postIds) {
        this.postIds = postIds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", deptId=").append(deptId);
        sb.append(", userName=").append(userName);
        sb.append(", nickName=").append(nickName);
        sb.append(", userType=").append(userType);
        sb.append(", email=").append(email);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", sex=").append(sex);
        sb.append(", avatar=").append(avatar);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}