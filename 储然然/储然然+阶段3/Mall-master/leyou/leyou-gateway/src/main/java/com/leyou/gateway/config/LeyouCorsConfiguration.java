package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class LeyouCorsConfiguration {

    @Bean
    public CorsFilter corsFilter()
    {
        CorsConfiguration configuration = new CorsConfiguration();
        //允许跨域的域名，如果要携带cookie，不能写*。*：代表所有的域名都可以跨域访问
        configuration.addAllowedOrigin("http://manage.leyou.com");
        //configuration.addAllowedOrigin("http://www.leyou.com");
        configuration.setAllowCredentials(true);//允许携带cookie
        configuration.addAllowedMethod("*");//代表所有的请求方法：GET POST PUT Delete
        configuration.addAllowedHeader("*");//允许携带任何头信息
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(configurationSource);
    }
}
