package com.oktfolio.kite.common.enums

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */

interface ResultCode {
    /**
     * value
     * @return
     */
    fun value(): Int

    /**
     * message
     * @return
     */
    fun message(): String?
}