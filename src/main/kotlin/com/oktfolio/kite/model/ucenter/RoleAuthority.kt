package com.oktfolio.kite.model.ucenter

import com.oktfolio.kite.model.BaseModel


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
data class RoleAuthority(var id: Long,
                         var roleCode: String,
                         var authorityCode: String) : BaseModel()