package com.lemonyangzw.stusystem.common.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import com.lemonyangzw.stusystem.common.constant.Constants;
import com.lemonyangzw.stusystem.framework.security.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yang
 * @date 2020/8/25 14:14
 */
@Component
public class TokenUtils {
    // 令牌自定义标识
    @Value("${token.header}")
    private String tokenHeader;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int tokenExpireTime;

    // 令牌有效期（默认30分钟）
    @Value("${token.key}")
    private String key;

    /**
     * @param request
     * @return 从请求头里获取token
     */
    public String getToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");

        }
        return token;
    }

    /**
     * @param request
     * @return 从token 中获取用户信息
     */
    public LoginUser getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
//            String userKey = getTokenKey(uuid);
//            LoginUser user = redisCache.getCacheObject(userKey);

            return new LoginUser();
        }
        return null;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Base64.encode(key).getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 创建令牌
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(LoginUser loginUser)
    {
        String token = IdUtil.fastUUID();
        loginUser.setToken(token);
//        setUserAgent(loginUser);
//        refreshToken(loginUser);

        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, token);
        return createToken(claims);
    }

    private String createToken(Map<String, Object> claims) {
//        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        // 生成密钥
        SecretKey secretKey = new SecretKeySpec(Base64.encode(key).getBytes(), SignatureAlgorithm.HS512.getJcaName());
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(secretKey)
                .compact();
        return token;
    }
}
