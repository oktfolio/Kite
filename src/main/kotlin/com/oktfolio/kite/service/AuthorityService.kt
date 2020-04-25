package com.oktfolio.kite.service

import com.oktfolio.kite.common.Authority
import com.oktfolio.kite.common.AuthorityGroup


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
interface AuthorityService {

    fun getAuthorityByCode(code: String): Authority

    fun getAuthorityGroupGroupBy(): List<AuthorityGroup>

}