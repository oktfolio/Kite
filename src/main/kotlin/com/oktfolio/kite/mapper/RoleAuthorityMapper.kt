package com.oktfolio.kite.mapper

import org.apache.ibatis.annotations.Mapper

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Mapper
interface RoleAuthorityMapper {

    fun selectAuthorityCodeListByRoleCodeList(roleCodeList: List<String>): List<String>
}