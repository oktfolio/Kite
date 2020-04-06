package com.oktfolio.kite.security.exceptions

import org.springframework.security.core.AuthenticationException

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */
class InvalidVerificationCodeException : AuthenticationException {
    constructor(msg: String?, t: Throwable?) : super(msg, t)
    constructor(msg: String?) : super(msg)
}