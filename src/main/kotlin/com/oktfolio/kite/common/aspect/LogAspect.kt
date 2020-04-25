package com.oktfolio.kite.common.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Aspect
class LogAspect {

    @Pointcut("@annotation(com.oktfolio.kite.common.annotation.Log)")
    fun controllerAspect() {
    }

    @Before("controllerAspect()")
    @Throws(InterruptedException::class)
    fun doBefore(joinPoint: JoinPoint) {
    }

    @After("controllerAspect()")
    fun after(joinPoint: JoinPoint, authentication: Authentication) {
        val userDetails = authentication.principal as UserDetails
        val username = userDetails.username
    }
}