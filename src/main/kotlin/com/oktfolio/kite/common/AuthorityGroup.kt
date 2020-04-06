package com.oktfolio.kite.common

import com.oktfolio.kite.common.Authority
import com.oktfolio.kite.common.enums.AuthorityGroupEnum


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/20
 */
data class AuthorityGroup(val group: AuthorityGroupEnum,
                          val authorities: List<Authority>)