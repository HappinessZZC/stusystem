package com.lemonyangzw.stusystem.framework.security.service;

import com.lemonyangzw.stusystem.common.exception.UserPasswordNotMatchException;
import com.lemonyangzw.stusystem.common.utils.TokenUtils;
import com.lemonyangzw.stusystem.framework.security.LoginUser;
import com.lemonyangzw.stusystem.framework.security.provider.SecurityAuthenticationProvider;
import com.lemonyangzw.stusystem.project.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private SysUserMapper sysUserMapper;
    @Resource
    private SecurityAuthenticationProvider authenticationManager;

    public String login(Map<String, String> map) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(map.get("username"), map.get("password")));
        } catch (Exception e) {
            throw new UserPasswordNotMatchException();
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenUtils.createToken(loginUser);
    }
}
