package com.oktfolio.kite.security.handlers

import com.oktfolio.kite.security.model.ExtendedUserDetails
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/15
 */
@Component
class AuthenticationSuccessHandlerImpl : SimpleUrlAuthenticationSuccessHandler() {

    companion object {
        private val logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl::class.java)
    }

    @Throws(IOException::class, ServletException::class, IOException::class)
    override fun onAuthenticationSuccess(request: HttpServletRequest?,
                                         response: HttpServletResponse,
                                         authentication: Authentication) {
        val userDetails: ExtendedUserDetails = authentication.principal as ExtendedUserDetails
        Companion.logger.info("onAuthenticationSuccess username: ${userDetails.username}")
        response.status = HttpStatus.OK.value()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
    }
}