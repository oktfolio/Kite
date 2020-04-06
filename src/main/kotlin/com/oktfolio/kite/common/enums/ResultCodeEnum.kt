package com.oktfolio.kite.common.enums

import com.oktfolio.kite.common.enums.ResultCode

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */

enum class ResultCodeEnum(private val value: Int,
                          private val message: String) : ResultCode {
    // Success
    SUCCESS(20000, "Success"),
    // Error
    ERROR(40000, "Error"),
    // invalid params
    INVALID_PARAMS(40010, "Invalid params"),
    // Internal server error
    INTERNAL_SERVER_ERROR(50000, "Internal server error"),
    // unauthorized
    UNAUTHORIZED(40100, "Unauthorized"),
    // forbidden
    FORBIDDEN(40300, "Forbidden"),
    // need to login
    NEED_LOGIN(40301, "Need to login"),
    // access denied
    ACCESS_DENIED(40300, "Access denied"),
    // not found
    NOT_FOUND(40400, "Not found");

    override fun value(): Int {
        return value
    }

    override fun message(): String {
        return message
    }

}