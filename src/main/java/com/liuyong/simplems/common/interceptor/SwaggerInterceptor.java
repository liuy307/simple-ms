package com.liuyong.simplems.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//替换private final Logger logger = LoggerFactory.getLogger(当前类名.class);直接使用log.info()
@Component//标明组件
public class SwaggerInterceptor implements HandlerInterceptor {
    @Value("${swagger.enabled:false}")//将外部配置文件的值动态注入到Bean中。
    private Boolean enabledSwagger;

    @Value("${swagger.redirect-uri:/}")
    private String redirectUri;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!enabledSwagger) {
            String uri = request.getContextPath();
            if(StringUtils.isNotBlank(redirectUri))
                uri = request.getContextPath() + redirectUri;
            if(StringUtils.isBlank(uri))
                uri = "/";
            try {
                response.sendRedirect(uri);
            } catch (IOException e) {
                log.error(String.format("Redirect to '%s' for swagger throw an exception : %s", uri, e.getMessage()), e);
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
