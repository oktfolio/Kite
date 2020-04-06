package com.oktfolio.kite.mapper

import com.oktfolio.kite.model.ucenter.User
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Mapper
interface UserMapper {
    fun selectByUsername(username: String?): User
    fun selectByEmail(email: String?): User
    fun selectByPhone(mobile: String?): User
}