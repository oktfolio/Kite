package com.oktfolio.kite.config

import org.hibernate.validator.HibernateValidator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.validation.Validation
import javax.validation.Validator


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */
@Configuration
class ValidateConfig {

    @Bean
    fun validator(): Validator? {
        val validatorFactory = Validation.byProvider(HibernateValidator::class.java)
                .configure()
                // 开启快速校验--默认校验所有参数，false校验全部
                .addProperty("hibernate.validator.fail_fast", "false")
                .buildValidatorFactory()
        return validatorFactory.validator
    }
}