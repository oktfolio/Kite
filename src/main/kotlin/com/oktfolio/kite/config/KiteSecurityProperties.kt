package com.oktfolio.kite.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/17
 */
@Component
@ConfigurationProperties(prefix = "kite.security", ignoreInvalidFields = false, ignoreUnknownFields = true)
data class KiteSecurityProperties(
        val test: List<String>
)
