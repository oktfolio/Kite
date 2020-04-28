package com.oktfolio.kite.mapper

import com.oktfolio.kite.model.RoleDO
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository
import tk.mybatis.mapper.common.BaseMapper
import tk.mybatis.mapper.common.MySqlMapper


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Repository
interface RoleMapper : BaseMapper<RoleDO>, MySqlMapper<RoleDO> {
    fun selectRoleListByRoleCodeAndStatus(@Param("code") code: String,
                                          @Param("status") status: Int)

    fun selectRoleCodeListByRoleCodeListAndStatus(@Param("codeList") codeList: List<String>,
                                                  @Param("status") status: Int): List<String>

}