package com.oktfolio.kite.model

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
class UserDO(
        var username: String? = null,
        var nickname: String? = null,
        var realName: String? = null,
        var avatar: String? = null,
        var gender: String? = null,
        var email: String? = null,
        var mobile: String? = null,
        var password: String? = null,
        var positionId: Long? = null,
        var departmentId: Long? = null,
        var credentialExpired: Boolean? = null,
        var locked: Boolean? = null,
        var enabled: Boolean? = null,
        var expired: Boolean? = null,
        var deleted: Boolean? = null) : BaseModel() {

    companion object {
        fun usernameRegister(username: String?,
                             password: String?): UserDO {
            val userDO = UserDO()
            userDO.username = username
            userDO.password = password
            return userDO
        }

        fun emailRegister(email: String?): UserDO {
            val userDO = UserDO()
            userDO.email = email
            return userDO
        }

        fun phoneRegister(mobile: String?): UserDO {
            val userDO = UserDO()
            userDO.mobile = mobile
            return userDO
        }
    }
}