package com.yjy.config;

import com.yjy.filter.LoginCheckFilter;
import com.yjy.intercepter.LoginCheckIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckIntercepter loginCheckIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(loginCheckIntercepter).addPathPatterns("/**")
                .excludePathPatterns("/login");
    }

}
