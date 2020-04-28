package com.oktfolio.kite.model



/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
data class UserDO(
        var id: Long,
        var username: String,
        var nickname: String,
        var realName: String,
        var avatar: String,
        var gender: String,
        var email: String?,
        var mobile: String?,
        var password: String,
        var positionId: Long,
        var departmentId: Long,
        var credentialExpired: Boolean,
        var locked: Boolean,
        var enabled: Boolean,
        var expired: Boolean,
        var deleted: Boolean) : BaseModel()