package com.oktfolio.kite.security.filter

import com.oktfolio.kite.security.authentication.PhoneAuthenticationToken
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/05/04
 */
class JsonAndFormDataPhoneAuthenticationFilter : AbstractAuthenticationProcessingFilter(AntPathRequestMatcher("/login/phone", "POST")) {

    private val postOnly = true

    @Throws(AuthenticationException::class, IOException::class, ServletException::class)
    override fun attemptAuthentication(httpServletRequest: HttpServletRequest?, httpServletResponse: HttpServletResponse?): Authentication {
        Companion.logger.info("attemptAuthentication")
        return authenticationManager.authenticate(PhoneAuthenticationToken("phone", "phone"))
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(JsonAndFormDataPhoneAuthenticationFilter::class.java)
        private const val PHONE = "phone"
        private const val VERIFICATION_CODE = "verificationCode"
    }
}