package com.lemonyangzw.stusystem.project.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lemonyangzw.stusystem.common.utils.HttpServletRequstHelper;
import com.lemonyangzw.stusystem.common.utils.PageUtils;
import com.lemonyangzw.stusystem.project.system.domain.SysUser;
import com.lemonyangzw.stusystem.project.system.mapper.SysUserMapper;
import com.lemonyangzw.stusystem.project.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    public List<SysUser> getUserAll(){
        PageUtils.startPageByRequest();
        return sysUserMapper.selectAll();
    }
}
