package com.lemonyangzw.stusystem.project.system.mapper;


import com.lemonyangzw.stusystem.project.system.domain.SysUserRole;

import java.util.List;

public interface SysUserRoleMapper {
    /**
     * 批量新增用户角色信息
     *
     * @param userRoleList 用户角色列表
     * @return 结果
     */
    int batchUserRole(List<SysUserRole> userRoleList);
}