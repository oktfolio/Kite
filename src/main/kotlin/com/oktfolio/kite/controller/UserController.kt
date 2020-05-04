package com.oktfolio.kite.controller

import com.oktfolio.kite.common.annotation.Log
import com.oktfolio.kite.common.enums.LogTypeEnum
import com.oktfolio.kite.model.UserDO
import com.oktfolio.kite.model.UserRegisterBO
import com.oktfolio.kite.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @Log(name = "REGISTER_USER_USERNAME", type = LogTypeEnum.CREATE)
    @PostMapping("/register/username")
    fun registerByUsername(@RequestBody registerBO: UserRegisterBO): ResponseEntity<Any> {
        val userDO = UserDO.usernameRegister(registerBO.username, registerBO.password)
        val res = userService.insert(userDO)
        return ResponseEntity.ok().build()
    }

    @Log(name = "REGISTER_USER_PHONE", type = LogTypeEnum.CREATE)
    @PostMapping("/register/phone")
    fun registerByPhone(@RequestBody registerBO: UserRegisterBO): ResponseEntity<Any> {
        val userDO = UserDO.phoneRegister(registerBO.mobile)
        val res = userService.insert(userDO)
        return ResponseEntity.ok().build()
    }

    @Log(name = "REGISTER_USER_EMAIL", type = LogTypeEnum.CREATE)
    @PostMapping("/register/email")
    fun registerByEmail(@RequestBody registerBO: UserRegisterBO): ResponseEntity<Any> {
        val userDO = UserDO.emailRegister(registerBO.email);
        val res = userService.insert(userDO)
        return ResponseEntity.ok().build()
    }

}