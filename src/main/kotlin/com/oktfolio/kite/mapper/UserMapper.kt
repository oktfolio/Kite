package com.oktfolio.kite.mapper

import com.oktfolio.kite.model.ucenter.UserDO
import org.apache.ibatis.annotations.Mapper

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Mapper
interface UserMapper {

    fun selectByUsername(username: String?): UserDO

    fun selectByEmail(email: String?): UserDO

    fun selectByPhone(mobile: String?): UserDO

}