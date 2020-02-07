package com.example.springboot04web.config;

import com.example.springboot04web.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer webMvcConfigurer()
    {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //不需要管静态资源
                //SpringBoot已经做好了静态资源映射
                 registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                         excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**");
            }
        };
        return webMvcConfigurer;
    }
}
