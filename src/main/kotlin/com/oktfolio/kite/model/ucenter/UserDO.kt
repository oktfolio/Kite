package com.oktfolio.kite.model.ucenter

import com.baomidou.mybatisplus.annotation.TableName
import com.oktfolio.kite.model.BaseModel


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@TableName("kite_user")
data class UserDO(
        var id: Long,
        var username: String,
        var nickname: String,
        var avatar: String,
        var gender: String,
        var email: String?,
        var mobile: String?,
        var password: String,
        var occupationId: Long,
        var departmentId: Long,
        var status: Int,
        var deleted: Boolean) : BaseModel()