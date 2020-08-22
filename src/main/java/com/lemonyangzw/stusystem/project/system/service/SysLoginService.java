package com.lemonyangzw.stusystem.project.system.service;

import cn.hutool.core.util.IdUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Yang
 * @date 2020/8/21 14:45
 */
@Component
public class SysLoginService {
    public String login(Map<String , String > map){
        // 生成令牌
        String token = IdUtil.fastUUID();
        map.put("login_user_key", token);
        token = Jwts.builder().setClaims(map).signWith(Keys.secretKeyFor(SignatureAlgorithm.HS256)).compact();
        //用户验证
        Authentication authentication = null;
        return token;
    }
}
