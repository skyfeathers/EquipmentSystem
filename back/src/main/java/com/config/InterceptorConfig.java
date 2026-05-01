package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.interceptor.AuthorizationInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport{
	
	@Bean
    public AuthorizationInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/**")
        		.excludePathPatterns("/static/**", "/front/**");
        super.addInterceptors(registry);
	}
	
	/**
	 * springboot 2.0配置WebMvcConfigurationSupport之后，会导致默认配置被覆盖，要访问静态资源需要重写addResourceHandlers方法
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 勿用 /** + classpath:/front/，否则 /front/index.html 会映射到 front/front/index.html（多一层 front），导致入口 404
		registry.addResourceHandler("/front/**")
				.addResourceLocations("classpath:/front/");
		registry.addResourceHandler("/admin/**")
				.addResourceLocations("classpath:/admin/");
		registry.addResourceHandler("/**")
				.addResourceLocations(
						"classpath:/resources/",
						"classpath:/static/",
						"classpath:/public/");
		super.addResourceHandlers(registry);
    }
}
