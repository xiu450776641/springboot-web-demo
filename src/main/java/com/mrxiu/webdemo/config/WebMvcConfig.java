package com.mrxiu.webdemo.config;

import com.mrxiu.webdemo.dispatch.LoggerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    LoggerInterceptor loggerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loggerInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/image/**", "/js/**", "/favicon.ico", "/login", "/error");
    }
}
