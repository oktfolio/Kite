package com.oktfolio.kite.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Mapper
interface UserRoleMapper {
    fun selectRoleCodeListByUserId(@Param("userId") userId: Long): List<String>
    fun selectRoleCodeListByUsername(@Param("username") username: String): List<String>
}