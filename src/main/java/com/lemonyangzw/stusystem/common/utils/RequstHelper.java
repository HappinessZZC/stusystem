package com.lemonyangzw.stusystem.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yang
 * @date 2020/11/9 14:01
 */
public class RequstHelper {
    /**
     * 获取当前 Request
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            throw new IllegalStateException("当前线程中不存在 Request 上下文");
        }
        return requestAttributes.getRequest();
    }
}
