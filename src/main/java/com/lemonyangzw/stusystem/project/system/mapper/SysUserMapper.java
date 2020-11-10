package com.lemonyangzw.stusystem.project.system.mapper;

import com.lemonyangzw.stusystem.project.system.domain.SysUser;

import java.util.List;

public interface SysUserMapper {
    SysUser selectUserByUserName(String username);

    List<SysUser> selectAll();
}