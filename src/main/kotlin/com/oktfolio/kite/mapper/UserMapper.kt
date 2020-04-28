package com.oktfolio.kite.mapper

import com.oktfolio.kite.model.UserDO
import org.apache.ibatis.annotations.Mapper
import tk.mybatis.mapper.common.BaseMapper
import tk.mybatis.mapper.common.MySqlMapper

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Mapper
interface UserMapper : BaseMapper<UserDO>, MySqlMapper<UserDO> {

    fun selectByUsername(username: String?): UserDO

    fun selectByEmail(email: String?): UserDO

    fun selectByPhone(mobile: String?): UserDO

}