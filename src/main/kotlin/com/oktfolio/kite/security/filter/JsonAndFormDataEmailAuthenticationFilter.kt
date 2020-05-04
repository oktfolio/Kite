package com.oktfolio.kite.security.filter

import com.oktfolio.kite.security.authentication.EmailAuthenticationToken
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.StringRedisTemplate
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
class JsonAndFormDataEmailAuthenticationFilter : AbstractAuthenticationProcessingFilter(AntPathRequestMatcher("/login/email", "POST")) {
    private var stringRedisTemplate: StringRedisTemplate? = null
    private val postOnly = true

    @Throws(AuthenticationException::class, IOException::class, ServletException::class)
    override fun attemptAuthentication(httpServletRequest: HttpServletRequest?, httpServletResponse: HttpServletResponse?): Authentication {
        Companion.logger.info("attemptAuthentication")
        return authenticationManager.authenticate(EmailAuthenticationToken("email", 12345))
    }

    fun getStringRedisTemplate(): StringRedisTemplate? {
        return stringRedisTemplate
    }

    fun setStringRedisTemplate(stringRedisTemplate: StringRedisTemplate?) {
        this.stringRedisTemplate = stringRedisTemplate
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(JsonAndFormDataEmailAuthenticationFilter::class.java)
        private const val EMAIL = "email"
        private const val VERIFICATION_CODE = "verificationCode"
    }
}