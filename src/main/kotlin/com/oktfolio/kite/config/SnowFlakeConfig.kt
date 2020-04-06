package com.oktfolio.kite.config

import com.oktfolio.kite.utils.SnowFlake
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */
@Configuration
class SnowFlakeConfig {

    @Autowired
    private lateinit var xiLingSnowFlakeProperties: XiLingSnowFlakeProperties

    @Bean
    fun snowFlake(): SnowFlake? {
        val snowFlake = SnowFlake()
        snowFlake.setDataCenterId(xiLingSnowFlakeProperties.centerId)
        snowFlake.setMachineId(xiLingSnowFlakeProperties.machineId)
        return snowFlake
    }
}
