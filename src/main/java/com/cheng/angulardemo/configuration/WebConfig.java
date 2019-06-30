package com.cheng.angulardemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfig
 * @Description TODO
 * @Author ch.zhang
 * @Date 2019/6/11 18:24
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    WebInterceptor webInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*","https://localhost/")
            .allowCredentials(true)
            .allowedMethods("GET","POST","PUT","DELETE","HEAD","OPTIONS")
            //解决angular跨域问题 Access-Control-Allow-Origin
            .allowedHeaders("*")
            .exposedHeaders("access-control-allow-headers","access-control-allow-methods",
                "access-control-allow-origin","access-control-max-age","X-Frame-Options")
            .allowCredentials(false).maxAge(3600);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("login");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(webInterceptor).addPathPatterns("/**").excludePathPatterns(
//            "/toLogin","/login","/error","/img/**","/css/**","/js/**","/font/**","/ico/**"
//        );
//    }
}
