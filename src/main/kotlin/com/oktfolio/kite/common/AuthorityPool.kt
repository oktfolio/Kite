package com.oktfolio.kite.common

import com.oktfolio.kite.common.enums.AuthorityGroupEnum
import java.util.concurrent.ConcurrentHashMap

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/18
 */
class AuthorityPool {

    companion object {
        private val authorityMap: ConcurrentHashMap<String, Authority> = ConcurrentHashMap()

        fun putAuthority(code: String, name: String, group: AuthorityGroupEnum) {
            authorityMap[code] = Authority(code, name, group)
        }

        fun putAuthority(authority: Authority) {
            authorityMap[authority.code] = Authority(authority.code, authority.name, authority.group)
        }

        fun getAuthorityList(): List<Authority> {
            return authorityMap.values.toList()
        }

        fun getAuthorityCodeList(): List<String> {
            return authorityMap.values.map { it.code }.toList()
        }

        fun getAuthorityGroup(): Map<AuthorityGroupEnum, List<Authority>> {
            return getAuthorityList().groupBy { it.group }
        }

        fun getAuthorityGroupList(): List<AuthorityGroup> {
            val authorityGroupMap = getAuthorityGroup()
            val authorityGroupList = arrayListOf<AuthorityGroup>()
            authorityGroupMap.keys.forEach {
                authorityGroupList.add(AuthorityGroup(it, authorityGroupMap.getValue(it)))
            }
            return authorityGroupList
        }

        fun getAuthorityByCode(code: String): Authority {
            return authorityMap[code]!!
        }
    }
}