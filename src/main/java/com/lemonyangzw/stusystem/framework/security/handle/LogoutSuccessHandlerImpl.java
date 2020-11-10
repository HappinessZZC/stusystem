package com.lemonyangzw.stusystem.framework.security.handle;

import cn.hutool.json.JSON;
import com.lemonyangzw.stusystem.common.utils.JsonUtils;
import com.lemonyangzw.stusystem.common.utils.StringUtils;
import com.lemonyangzw.stusystem.common.utils.TokenUtils;
import com.lemonyangzw.stusystem.framework.security.LoginUser;
import com.lemonyangzw.stusystem.framework.web.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义退出处理类 返回成功
 * 
 * @author ruoyi
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler
{
    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 退出处理
     * 
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException
    {
        LoginUser loginUser = tokenUtils.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser))
        {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            String token = loginUser.getToken();
            if(StringUtils.isNotEmpty(token)){
                redisTemplate.delete(tokenUtils.getTokenKey(token));
            }
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(JsonUtils.toJsonString(AjaxResult.error(200, "退出成功")));
        }
    }

}
