package com.lemonyangzw.stusystem.project.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemonyangzw.stusystem.project.system.domain.SysUserPost;

import java.util.List;

/**
 * @author Yang
 * @date 2020/11/12 14:02
 */
public interface SysUserPostMapper extends BaseMapper<SysUserPost> {
    /**
     * 批量新增用户岗位信息
     *
     * @param userPostList 用户角色列表
     * @return 结果
     */
    int batchUserPost(List<SysUserPost> userPostList);

    /**
     * 通过用户ID删除用户和岗位关联
     *
     * @param userId 用户ID
     * @return 结果
     */
    int deleteUserPostByUserId(Long userId);
}
