package com.oktfolio.kite.model.ucenter

import com.oktfolio.kite.model.BaseModel


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
data class UserRole(var id: Long,
                    var userId: Long,
                    var username: String,
                    var roleCode: String) : BaseModel()