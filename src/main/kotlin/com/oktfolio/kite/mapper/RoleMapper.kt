package com.oktfolio.kite.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Mapper
interface RoleMapper {
    fun selectRoleListByRoleCodeAndStatus(@Param("code") code: String,
                                          @Param("status") status: Int)

    fun selectRoleCodeListByRoleCodeListAndStatus(@Param("codeList") codeList: List<String>,
                                                  @Param("status") status: Int): List<String>

}