package com.lemonyangzw.stusystem.project.system.service;

import com.lemonyangzw.stusystem.project.system.domain.SysPost;

import java.util.List;

/**
 * @author Yang
 * @date 2020/11/12 9:12
 */
public interface SysPostService {
    List<SysPost> getPostAll();

    /**
     * 根据用户ID获取岗位选择框列表
     *
     * @param userId 用户ID
     * @return 选中岗位ID列表
     */
    List<Integer> selectPostListByUserId(Long userId);
}
