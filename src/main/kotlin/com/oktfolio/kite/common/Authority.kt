package com.oktfolio.kite.common

import com.oktfolio.kite.common.enums.AuthorityGroupEnum


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/18
 */
data class Authority(val code: String,
                     val name: String,
                     val group: AuthorityGroupEnum)