package com.lemonyangzw.stusystem.framework.security.handle;

import com.lemonyangzw.stusystem.framework.security.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Yang
 * @date 2020/8/26 9:42
 */
@Component
public class SecurityAuthentication implements AuthenticationProvider {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        //TODO:缺少判断是否存在用户逻辑，待添加
        LoginUser loginUser = new LoginUser();
        Collection<? extends GrantedAuthority> authorities = loginUser.getAuthorities();
        return new UsernamePasswordAuthenticationToken(loginUser,password,authorities);
    }

    /**
     * 执行支持判断
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
