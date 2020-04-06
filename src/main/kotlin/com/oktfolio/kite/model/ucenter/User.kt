package com.oktfolio.kite.model.ucenter

import com.oktfolio.kite.model.BaseModel


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
data class User(
        var id: Long,
        var username: String,
        var email: String?,
        var mobile: String?,
        var password: String) : BaseModel()