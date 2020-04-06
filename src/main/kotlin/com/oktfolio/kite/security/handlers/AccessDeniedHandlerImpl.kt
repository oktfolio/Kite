package com.oktfolio.kite.security.handlers

import com.fasterxml.jackson.databind.ObjectMapper
import com.oktfolio.kite.common.enums.ResultCodeEnum
import com.oktfolio.kite.common.result.ResultEntity
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
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
class AccessDeniedHandlerImpl : AccessDeniedHandler {

    companion object {
        private val logger = LoggerFactory.getLogger(AccessDeniedHandlerImpl::class.java)
    }

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Throws(IOException::class, ServletException::class)
    override fun handle(httpServletRequest: HttpServletRequest?,
                        httpServletResponse: HttpServletResponse,
                        e: AccessDeniedException) {
        logger.info(e.message)
        httpServletResponse.status = HttpStatus.FORBIDDEN.value()
        httpServletResponse.contentType = MediaType.APPLICATION_JSON_VALUE
        httpServletResponse.writer
                .write(objectMapper
                        .writeValueAsString(ResultEntity
                                .forbidden(ResultCodeEnum.ACCESS_DENIED)))
    }
}