package com.oktfolio.kite.controller.admin

import com.oktfolio.kite.common.annotation.Log
import com.oktfolio.kite.common.constant.AuthorityCode
import com.oktfolio.kite.common.enums.LogTypeEnum
import com.oktfolio.kite.model.ucenter.UserDO
import com.oktfolio.kite.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/20
 */
@RestController
@RequestMapping("admin/users")
class AdminUserController {

    @Autowired
    private lateinit var userService: UserService

    @Log(name = "CREATE_USER", type = LogTypeEnum.CREATE)
    @PreAuthorize(AuthorityCode.AdminUser.HAS_AUTHORITY_CREATE)
    @PostMapping("")
    fun createUser(@RequestBody userDO: UserDO): ResponseEntity<Any> {
        userService.insert(userDO)
        return ResponseEntity.ok().build()
    }

    @GetMapping("")
    fun listUser() {
    }

    @GetMapping("{username}")
    fun retrieveUser(@PathVariable("username") username: String) {
    }

    @PutMapping("{username}")
    fun updateUser(@PathVariable("username") username: String) {
    }

    @DeleteMapping("{username}")
    fun deleteUser(@PathVariable("username") username: String) {
    }

    @PatchMapping("{username}/status")
    fun disable(@PathVariable("username") username: String) {
    }
}
