package com.oktfolio.kite.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/17
 */
@Component
@ConfigurationProperties(prefix = "xi-ling.snowflake", ignoreInvalidFields = false, ignoreUnknownFields = true)
data class XiLingSnowFlakeProperties(
        var centerId: Long = 0L,
        var machineId: Long = 0L
)
