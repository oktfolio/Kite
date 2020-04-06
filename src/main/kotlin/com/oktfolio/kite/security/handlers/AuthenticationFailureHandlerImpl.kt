package com.oktfolio.kite.security.handlers

import com.fasterxml.jackson.databind.ObjectMapper
import com.oktfolio.kite.common.result.ResultEntity
import com.oktfolio.kite.security.exceptions.InvalidAuthenticationRequestBodyException
import com.oktfolio.kite.security.exceptions.InvalidVerificationCodeException
import com.oktfolio.kite.common.enums.UserResultCodeEnum
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.authentication.*
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */
@Component
class AuthenticationFailureHandlerImpl : SimpleUrlAuthenticationFailureHandler() {

    companion object {
        private val logger = LoggerFactory.getLogger(AuthenticationFailureHandlerImpl::class.java)
    }

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationFailure(request: HttpServletRequest?,
                                         response: HttpServletResponse,
                                         exception: AuthenticationException) {
        if (exception is UsernameNotFoundException || exception is BadCredentialsException) {
            Companion.logger.info(exception.message)
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writer.write(
                    objectMapper.writeValueAsString(
                            ResultEntity.unauthorized(UserResultCodeEnum.BAD_USERNAME_PASSWORD)))
        } else if (exception is AccountExpiredException) {
            Companion.logger.info(exception.message)
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writer.write(
                    objectMapper.writeValueAsString(
                            ResultEntity.unauthorized(UserResultCodeEnum.USER_EXPIRED)))
        } else if (exception is LockedException) {
            Companion.logger.info(exception.message)
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writer.write(
                    objectMapper.writeValueAsString(
                            ResultEntity.unauthorized(UserResultCodeEnum.USER_LOCKED)))
        } else if (exception is CredentialsExpiredException) {
            Companion.logger.info(exception.message)
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writer.write(
                    objectMapper.writeValueAsString(
                            ResultEntity.unauthorized(UserResultCodeEnum.CREDENTIALS_EXPIRED)))
        } else if (exception is DisabledException) {
            Companion.logger.info(exception.message)
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writer.write(
                    objectMapper.writeValueAsString(
                            ResultEntity.unauthorized(UserResultCodeEnum.USER_DISABLED)))
        } else if (exception is InvalidVerificationCodeException) {
            Companion.logger.info(exception.message)
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writer.write(
                    objectMapper.writeValueAsString(
                            ResultEntity.unauthorized(UserResultCodeEnum.INVALID_VERIFICATION_CODE)))
        } else if (exception is InvalidAuthenticationRequestBodyException) {
            Companion.logger.info(exception.message)
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writer.write(
                    objectMapper.writeValueAsString(
                            ResultEntity.unauthorized(UserResultCodeEnum.USERNAME_PASSWORD_CANNOT_BE_NULL)))
        } else {
            Companion.logger.info(exception.message)
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.writer.write(
                    objectMapper.writeValueAsString(
                            ResultEntity.unauthorized(UserResultCodeEnum.FAILED_LOGIN)))
        }
    }
}