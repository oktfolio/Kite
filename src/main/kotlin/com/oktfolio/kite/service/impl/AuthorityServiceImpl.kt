package com.oktfolio.kite.service.impl

import com.oktfolio.kite.common.Authority
import com.oktfolio.kite.common.AuthorityGroup
import com.oktfolio.kite.common.AuthorityPool
import com.oktfolio.kite.service.AuthorityService
import org.springframework.stereotype.Service


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Service
class AuthorityServiceImpl : AuthorityService {

    override fun getAuthorityByCode(code: String): Authority {
        return AuthorityPool.getAuthorityByCode(code)
    }

    override fun getAuthorityGroupGroupBy(): List<AuthorityGroup> {
        return AuthorityPool.getAuthorityGroupList()
    }

}