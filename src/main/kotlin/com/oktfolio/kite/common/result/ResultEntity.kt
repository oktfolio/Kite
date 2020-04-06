package com.oktfolio.kite.common.result

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.oktfolio.kite.common.enums.ResultCode
import org.springframework.http.HttpStatus
import java.time.LocalDateTime

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
class ResultEntity private constructor() {
    private var code: Int? = null
    private var message: String? = null
    private var data: Any? = null
    @JsonIgnore
    private var status: HttpStatus? = null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private var timestamp: LocalDateTime? = null

    fun getCode(): Int? {
        return code
    }

    private fun setCode(code: Int) {
        this.code = code
    }

    fun getMessage(): String? {
        return message
    }

    private fun setMessage(message: String) {
        this.message = message
    }

    fun getData(): Any? {
        return data
    }

    private fun setData(data: Any) {
        this.data = data
    }

    fun getStatus(): HttpStatus? {
        return status
    }

    private fun setStatus(status: HttpStatus) {
        this.status = status
    }

    fun getTimestamp(): LocalDateTime? {
        return timestamp
    }

    private fun setTimestamp(timestamp: LocalDateTime) {
        this.timestamp = timestamp
    }

    fun code(code: Int): ResultEntity {
        setCode(code)
        return this
    }

    fun message(message: String): ResultEntity {
        setMessage(message)
        return this
    }

    fun data(data: Any): ResultEntity {
        setData(data)
        return this
    }

    fun status(status: HttpStatus): ResultEntity {
        setStatus(status)
        return this
    }

    fun timestamp(timestamp: LocalDateTime): ResultEntity {
        setTimestamp(timestamp)
        return this
    }

    class Builder {
        private val resultEntity = ResultEntity()
        fun code(code: Int?): Builder {
            resultEntity.code = code
            return this
        }


        fun message(message: String?): Builder {
            resultEntity.message = message
            return this
        }

        fun data(data: Any?): Builder {
            resultEntity.data = data
            return this
        }

        fun timestamp(timestamp: LocalDateTime?): Builder {
            resultEntity.timestamp = timestamp
            return this
        }

        fun status(status: HttpStatus?): Builder {
            resultEntity.status = status
            return this
        }

        fun build(): ResultEntity {
            return resultEntity
        }
    }

    companion object {
        fun builder(): Builder {
            return Builder()
        }

        fun ok(): ResultEntity {
            return builder()
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build()
        }

        fun ok(data: Any?): ResultEntity {
            return builder()
                    .status(HttpStatus.OK)
                    .data(data)
                    .timestamp(LocalDateTime.now())
                    .build()
        }

        fun notFound(resultCode: ResultCode): ResultEntity {
            return builder()
                    .status(HttpStatus.NOT_FOUND)
                    .code(resultCode.value())
                    .message(resultCode.message())
                    .timestamp(LocalDateTime.now())
                    .build()
        }

        fun badRequest(resultCode: ResultCode): ResultEntity {
            return builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .code(resultCode.value())
                    .message(resultCode.message())
                    .build()
        }

        fun unauthorized(resultCode: ResultCode): ResultEntity {
            return builder()
                    .status(HttpStatus.UNAUTHORIZED)
                    .code(resultCode.value())
                    .message(resultCode.message())
                    .timestamp(LocalDateTime.now())
                    .build()
        }

        fun forbidden(resultCode: ResultCode): ResultEntity {
            return builder()
                    .status(HttpStatus.FORBIDDEN)
                    .code(resultCode.value())
                    .message(resultCode.message())
                    .timestamp(LocalDateTime.now())
                    .build()
        }

        fun created(): ResultEntity {
            return builder()
                    .status(HttpStatus.CREATED)
                    .build()
        }

        fun created(data: Any?): ResultEntity {
            return builder()
                    .data(data)
                    .status(HttpStatus.CREATED)
                    .build()
        }

        fun created(resultCode: ResultCode): ResultEntity {
            return builder()
                    .status(HttpStatus.CREATED)
                    .code(resultCode.value())
                    .message(resultCode.message())
                    .build()
        }

        fun internalServerError(): ResultEntity {
            return builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .timestamp(LocalDateTime.now())
                    .build()
        }

        fun internalServerError(resultCode: ResultCode): ResultEntity {
            return builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(resultCode.value())
                    .message(resultCode.message())
                    .timestamp(LocalDateTime.now())
                    .build()
        }
    }
}
