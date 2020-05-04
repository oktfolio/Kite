package com.oktfolio.kite.security.exception

import org.springframework.security.core.AuthenticationException


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/05/04
 */
class InvalidAuthenticationRequestBodyException : AuthenticationException {
    constructor(msg: String?, t: Throwable?) : super(msg, t)
    constructor(msg: String?) : super(msg)
}