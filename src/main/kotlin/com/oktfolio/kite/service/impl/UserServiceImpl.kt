package com.oktfolio.kite.service.impl

import com.oktfolio.kite.mapper.UserMapper
import com.oktfolio.kite.model.ucenter.UserDO
import com.oktfolio.kite.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userMapper: UserMapper

    override fun insert(userDO: UserDO) {

    }
}