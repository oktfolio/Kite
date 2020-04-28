package com.oktfolio.kite.model



/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
data class UserRoleDO(var id: Long,
                      var userId: Long,
                      var username: String,
                      var roleId: Long ) : BaseModel()