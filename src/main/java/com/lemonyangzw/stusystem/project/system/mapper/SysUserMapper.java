package com.lemonyangzw.stusystem.project.system.mapper;

import com.lemonyangzw.stusystem.project.system.domain.SysUser;

public interface SysUserMapper {
    SysUser selectUserById(Long userId);

}