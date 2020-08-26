package com.lemonyangzw.stusystem.project.system.service;

import com.lemonyangzw.stusystem.common.utils.TokenUtils;
import com.lemonyangzw.stusystem.framework.security.LoginUser;
import com.lemonyangzw.stusystem.framework.security.handle.SecurityAuthentication;
import com.lemonyangzw.stusystem.project.system.domain.SysUser;
import com.lemonyangzw.stusystem.project.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Yang
 * @date 2020/8/21 14:45
 */
@Component
public class SysLoginService {
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private SecurityAuthentication authenticationManager;
    @Autowired
    private SysUserMapper sysUserMapper;

    public String login(Map<String, String> map) {
        //认证
        sysUserMapper.selectUserById(1l);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(map.get("username"), map.get("password")));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenUtils.createToken(loginUser);
    }
}
