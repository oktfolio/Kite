package com.oktfolio.kite.service

import com.oktfolio.kite.model.UserDO
import com.oktfolio.kite.security.model.ExtendedUserDetails


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
interface UserService {
    fun insert(userDO: UserDO): Int

    fun selectByPhone(phone: String): ExtendedUserDetails?
    fun selectByEmail(email: String): ExtendedUserDetails?
}