package com.oktfolio.kite.common.annotation

import com.oktfolio.kite.common.enums.LogTypeEnum

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class Log(
        val name: String,
        val type: LogTypeEnum
)