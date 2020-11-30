package com.lemonyangzw.stusystem.project.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lemonyangzw.stusystem.framework.web.domain.BaseEntity;

/**
 * 岗位信息表
 *
 * @author Yang
 * @date 2020/11/30 9:24
 */
@TableName(value = "sys_post")
public class SysPost extends BaseEntity {
    public static final String COL_POST_ID = "post_id";
    public static final String COL_POST_CODE = "post_code";
    public static final String COL_POST_NAME = "post_name";
    public static final String COL_POST_SORT = "post_sort";
    public static final String COL_STATUS = "status";
    public static final String COL_REMARK = "remark";
    /**
     * 岗位ID
     */
    @TableId(value = "post_id", type = IdType.AUTO)
    private Long postId;
    /**
     * 岗位编码
     */
    @TableField(value = "post_code")
    private String postCode;
    /**
     * 岗位名称
     */
    @TableField(value = "post_name")
    private String postName;
    /**
     * 显示顺序
     */
    @TableField(value = "post_sort")
    private Integer postSort;
    /**
     * 状态（0正常 1停用）
     */
    @TableField(value = "`status`")
    private String status;
    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 获取岗位ID
     *
     * @return post_id - 岗位ID
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置岗位ID
     *
     * @param postId 岗位ID
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取岗位编码
     *
     * @return post_code - 岗位编码
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 设置岗位编码
     *
     * @param postCode 岗位编码
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * 获取岗位名称
     *
     * @return post_name - 岗位名称
     */
    public String getPostName() {
        return postName;
    }

    /**
     * 设置岗位名称
     *
     * @param postName 岗位名称
     */
    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    /**
     * 获取显示顺序
     *
     * @return post_sort - 显示顺序
     */
    public Integer getPostSort() {
        return postSort;
    }

    /**
     * 设置显示顺序
     *
     * @param postSort 显示顺序
     */
    public void setPostSort(Integer postSort) {
        this.postSort = postSort;
    }

    /**
     * 获取状态（0正常 1停用）
     *
     * @return status - 状态（0正常 1停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1停用）
     *
     * @param status 状态（0正常 1停用）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(postId);
        sb.append(", postCode=").append(postCode);
        sb.append(", postName=").append(postName);
        sb.append(", postSort=").append(postSort);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}