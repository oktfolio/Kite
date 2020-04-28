package com.oktfolio.kite.mapper

import com.oktfolio.kite.model.UserRoleDO
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import tk.mybatis.mapper.common.BaseMapper
import tk.mybatis.mapper.common.MySqlMapper


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Mapper
interface UserRoleMapper : BaseMapper<UserRoleDO>, MySqlMapper<UserRoleDO> {
    fun selectRoleCodeListByUserId(@Param("userId") userId: Long): List<String>
    fun selectRoleCodeListByUsername(@Param("username") username: String): List<String>
}