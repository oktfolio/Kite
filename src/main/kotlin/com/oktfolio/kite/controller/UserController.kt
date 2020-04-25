package com.oktfolio.kite.controller

import com.oktfolio.kite.common.annotation.Log
import com.oktfolio.kite.common.enums.LogTypeEnum
import com.oktfolio.kite.model.ucenter.UserDO
import com.oktfolio.kite.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@RestController
@RequestMapping("user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @Log(name = "REGISTER_USER", type = LogTypeEnum.CREATE)
    @PreAuthorize("@fullyAuthenticated")
    @PostMapping("register")
    fun register(@RequestBody userDO: UserDO): ResponseEntity<Any> {
        userService.insert(userDO)
        return ResponseEntity.ok().build()
    }

}