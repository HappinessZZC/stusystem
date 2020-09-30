package com.lemonyangzw.stusystem.framework.security;

import com.lemonyangzw.stusystem.common.utils.StringUtils;
import com.lemonyangzw.stusystem.framework.security.service.SysPermissionService;
import com.lemonyangzw.stusystem.project.system.domain.SysUser;
import com.lemonyangzw.stusystem.project.system.mapper.SysUserMapper;
import com.lemonyangzw.stusystem.project.system.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

/**
 * @author Yang
 * @date 2020/8/26 9:47
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.selectUserByUserName(username);
        if (StringUtils.isNull(user)) {
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        } else if ("2".equals(user.getDelFlag())) {
            log.info("登录用户：{} 已被删除.", username);
            throw new UsernameNotFoundException("对不起，您的账号：" + username + " 已被删除");
        } else if ("1".equals(user.getStatus())) {
            log.info("登录用户：{} 已被停用.", username);
            throw new UsernameNotFoundException("对不起，您的账号：" + username + " 已停用");
        }

        return createLoginUser(user);
    }

    private UserDetails createLoginUser(SysUser user) {
        return new LoginUser(user);
    }
}
