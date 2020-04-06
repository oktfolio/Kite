package com.oktfolio.kite.controller

import com.google.gson.Gson
import com.oktfolio.kite.common.AuthorityPool
import com.oktfolio.kite.common.enums.AuthorityEnum
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@RestController
class MainController {

    companion object{
        private val test= AuthorityEnum.ADMIN_USER_CREATE
    }

    @RequestMapping("/test")
    @PreAuthorize("hasAnyAuthority()")
    private fun test(): ResponseEntity<Any> {
        println(Gson().toJson(AuthorityPool.getAuthorityGroupList()))
        return ResponseEntity.ok().build()
    }
}