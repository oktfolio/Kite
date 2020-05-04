package com.oktfolio.kite.service.impl

import com.github.pagehelper.PageHelper
import com.oktfolio.kite.mapper.UserMapper
import com.oktfolio.kite.model.UserDO
import com.oktfolio.kite.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userMapper: UserMapper

    override fun insert(userDO: UserDO): Int {
        userDO.setCreateTime(LocalDateTime.now())
        userDO.setUpdateTime(LocalDateTime.now())
        return userMapper.insert(userDO)
    }

    fun listByCondition(pageNum: Int, pageSize: Int) {

        val page = PageHelper.startPage<UserDO>(pageNum, pageSize)
                .doSelectPage<UserDO> { userMapper.selectByEmail("") }
    }
}