package com.lemonyangzw.stusystem.project.system.service.impl;

import com.lemonyangzw.stusystem.project.system.domain.SysUser;
import com.lemonyangzw.stusystem.project.system.mapper.SysUserMapper;
import com.lemonyangzw.stusystem.project.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yang
 * @date 2020/9/10 14:19
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser selectUserByUserName(String username) {
        return sysUserMapper.selectUserByUserName(username);
    }
}
