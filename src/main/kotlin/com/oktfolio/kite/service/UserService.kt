package com.oktfolio.kite.service

import com.oktfolio.kite.model.ucenter.UserDO


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
interface UserService {
    fun insert(userDO: UserDO)
}