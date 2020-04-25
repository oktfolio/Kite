package com.oktfolio.kite.model.ucenter

import com.baomidou.mybatisplus.annotation.TableName
import com.oktfolio.kite.model.BaseModel


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@TableName("kite_user_role")
data class UserRoleDO(var id: Long,
                      var userId: Long,
                      var username: String,
                      var roleId: Long ) : BaseModel()