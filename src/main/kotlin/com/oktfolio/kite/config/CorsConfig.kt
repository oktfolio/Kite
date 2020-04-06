package com.oktfolio.kite.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */
@Configuration
@Order(-1)
class CorsConfig {
    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            // 添加映射路径
            override fun addCorsMappings(registry: CorsRegistry) {
                // 允许哪些原始域
                registry.addMapping("/**")
                        // 是否发送 Cookie 信息
                        .allowedOrigins("*")
                        // 响应报头指示的请求的响应是否可以暴露于该页面
                        .allowCredentials(true)
                        // 允许哪些请求方法
                        .allowedMethods("*")
                        // 允许哪些头信息
                        .allowedHeaders("*")
            }
        }
    }

    @Bean
    open fun corsConfigurationSource(): CorsConfigurationSource {
        val config = CorsConfiguration()
        config.addAllowedOrigin("*")
        config.addAllowedMethod("*")
        config.addAllowedHeader("*")
        config.allowCredentials = true
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", config)
        return source
    }
}