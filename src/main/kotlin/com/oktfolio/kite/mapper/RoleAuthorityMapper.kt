package com.oktfolio.kite.mapper

import com.oktfolio.kite.model.RoleAuthorityDO
import org.apache.ibatis.annotations.Mapper
import tk.mybatis.mapper.common.BaseMapper
import tk.mybatis.mapper.common.MySqlMapper

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Mapper
interface RoleAuthorityMapper: BaseMapper<RoleAuthorityDO>, MySqlMapper<RoleAuthorityDO> {

    fun selectAuthorityCodeListByRoleCodeList(roleCodeList: List<String>): List<String>
}