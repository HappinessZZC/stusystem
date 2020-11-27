package com.lemonyangzw.stusystem.framework.security.provider;

import com.lemonyangzw.stusystem.framework.security.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Yang
 * @date 2020/9/8 15:19
 */
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {
    /**
     * 注入我们自己定义的用户信息获取对象
     */
    @Autowired
    private UserDetailsService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();//用户名
        String password = (String) authentication.getCredentials();//密码
        LoginUser LoginUser = (LoginUser) userDetailService.loadUserByUsername(userName);
        if (LoginUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        passwordEncoder.encode(password);
        if (!passwordEncoder.matches(password, LoginUser.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }

        return new UsernamePasswordAuthenticationToken(
                LoginUser, password);// 构建返回的用户登录成功的token
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
