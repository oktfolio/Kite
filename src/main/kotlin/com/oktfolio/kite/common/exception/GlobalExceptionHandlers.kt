package com.oktfolio.kite.common.exception

import com.oktfolio.kite.common.enums.ResultCodeEnum
import com.oktfolio.kite.common.result.ResultEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@RestControllerAdvice
class GlobalExceptionHandlers {
    /**
     * 处理 Validator 异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun bindExceptionHandler(exception: MethodArgumentNotValidException): ResponseEntity<*> {
        val result = exception.bindingResult
        val fieldErrors = result.fieldErrors
        val map: HashMap<String, String> = HashMap(16)
        for (fieldError in fieldErrors) {
            map[fieldError.field] = fieldError.defaultMessage ?: ""
        }
        return ResponseEntity
                .badRequest()
                .body(ResultEntity.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .code(ResultCodeEnum.INVALID_PARAMS.value())
                        .message(ResultCodeEnum.INVALID_PARAMS.message())
                        .data(map)
                        .build())
    }

    /**
     * 运行时异常，未处理的运行时异常都走这里
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = [RuntimeException::class])
    fun runtimeExceptionHandler(exception: RuntimeException): ResponseEntity<*> {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResultEntity
                        .builder()
                        .code(ResultCodeEnum.INTERNAL_SERVER_ERROR.value())
                        .message(exception.message)
                        .timestamp(LocalDateTime.now())
                        .build())
    }
}