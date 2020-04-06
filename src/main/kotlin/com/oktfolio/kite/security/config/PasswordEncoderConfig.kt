package com.oktfolio.kite.security.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/15
 */
@Configuration
open class PasswordEncoderConfig {

    @Bean
    open fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}