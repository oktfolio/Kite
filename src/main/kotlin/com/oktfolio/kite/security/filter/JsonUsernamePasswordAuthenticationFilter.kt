package com.oktfolio.kite.security.filter

import com.oktfolio.kite.security.handlers.AuthenticationSuccessHandlerImpl
import com.oktfolio.kite.utils.JsonUtils
import com.oktfolio.kite.security.model.UsernamePassword
import org.slf4j.LoggerFactory
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */
class JsonUsernamePasswordAuthenticationFilter : UsernamePasswordAuthenticationFilter() {

    companion object {
        private val logger = LoggerFactory.getLogger(JsonUsernamePasswordAuthenticationFilter::class.java)
    }

    private val postOnly = true

    @Throws(AuthenticationException::class)
    override fun attemptAuthentication(request: HttpServletRequest,
                                       response: HttpServletResponse?): Authentication? {
        Companion.logger.info("JsonUsernamePasswordAuthenticationFilter attemptAuthentication")
        return if (postOnly && HttpMethod.POST.name != request.method) {
            throw AuthenticationServiceException("Authentication method not supported: " + request.method)
        } else {
            if (request.contentType.indexOf(MediaType.APPLICATION_JSON_VALUE) != -1) {
                Companion.logger.info("a json login request, continue")
                var authenticationToken: UsernamePasswordAuthenticationToken? = null
                try {
                    request.inputStream.use { inputStream ->
                        val usernamePassword: UsernamePassword =
                                JsonUtils.inputStream2Object(inputStream,
                                        UsernamePassword::class.java) as UsernamePassword
                        Companion.logger.info("json login , user: ${usernamePassword.username}")
                        authenticationToken = UsernamePasswordAuthenticationToken(
                                usernamePassword.username, usernamePassword.password)
                    }
                } catch (e: IOException) {
                    Companion.logger.error("failed to obtain json from request, ${e.message}")
                    authenticationToken = UsernamePasswordAuthenticationToken(
                            "", "")
                }
                setDetails(request, authenticationToken)
                this.authenticationManager.authenticate(authenticationToken)
            } else {
                // if not JSON request，continue with attemptAuthentication
                Companion.logger.info("not a json request, use default UsernamePasswordAuthenticationFilter")
                super.attemptAuthentication(request, response)
            }
        }
    }
}