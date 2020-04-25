package com.oktfolio.kite.model.ucenter

import com.baomidou.mybatisplus.annotation.TableName
import com.oktfolio.kite.model.BaseModel


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@TableName("kite_role_authority")
data class RoleAuthorityDO(var id: Long,
                           var roleId: String,
                           var authorityCode: String) : BaseModel()