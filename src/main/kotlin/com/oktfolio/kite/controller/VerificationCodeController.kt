package com.oktfolio.kite.controller

import com.oktfolio.kite.common.constant.Constants
import com.oktfolio.kite.model.UserVerificationCodeBo
import com.oktfolio.kite.service.UserService
import org.apache.tomcat.util.bcel.Const
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.*
import java.util.concurrent.TimeUnit
import javax.servlet.http.HttpSession


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/05/04
 */
class VerificationCodeController {

    @Autowired
    lateinit var userService: UserService

    @Autowired
    private val stringRedisTemplate: StringRedisTemplate? = null

    @PostMapping("/verification-code/captcha")
    fun imageVerification(session: HttpSession): ResponseEntity<*>? {
        val sessionId = session.id
        val code = randomStringCode()
        stringRedisTemplate!!
                .opsForValue()
                .set(Constants.VerificationCode.CAPTCHA + sessionId,
                        code,
                        15,
                        TimeUnit.MINUTES)
        return ResponseEntity.ok().build<Any>()
    }

    @PostMapping("/verification-code/call")
    fun sendCallVerification(@RequestBody userVerificationCodeBo: UserVerificationCodeBo): ResponseEntity<*>? {
        val phone = userVerificationCodeBo.phone
        val userDetails = userService.selectByPhone(phone)
        val code = randomStringCode()
        if (userDetails != null) {
            stringRedisTemplate!!
                    .opsForValue()
                    .set(Constants.VerificationCode.PHONE + phone,
                            code,
                            15,
                            TimeUnit.MINUTES)
        }
        return ResponseEntity.ok().build<Any>()
    }

    @PostMapping("/verification-code/sms")
    fun sendSmsVerification(@RequestBody userVerificationCodeBo: UserVerificationCodeBo): ResponseEntity<*>? {
        val phone = userVerificationCodeBo.phone
        val userDetails = userService.selectByPhone(phone)
        val code = randomStringCode()
        if (userDetails != null) {
            stringRedisTemplate!!
                    .opsForValue()
                    .set(Constants.VerificationCode.PHONE + phone,
                            code,
                            15,
                            TimeUnit.MINUTES)
        }
        return ResponseEntity.ok().build<Any>()
    }

    @PostMapping("/verification-code/email")
    fun sendEmailVerification(@RequestBody userVerificationCodeBo: UserVerificationCodeBo): ResponseEntity<*>? {
        val email = userVerificationCodeBo.email
        val userDetails = userService.selectByEmail(email)
        val code = randomStringCode()
        if (userDetails != null) {
            stringRedisTemplate!!
                    .opsForValue()
                    .set(Constants.VerificationCode.EMAIL + email,
                            code,
                            15,
                            TimeUnit.MINUTES)
        }
        return ResponseEntity.ok().build<Any>()
    }

    private fun randomStringCode(): String {
        return (Random().nextInt(899999) + 100000).toString()
    }
}