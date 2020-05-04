package com.oktfolio.kite.security.service

import com.oktfolio.kite.common.constant.Constants
import com.oktfolio.kite.common.enums.AuthorityEnum
import com.oktfolio.kite.mapper.RoleAuthorityMapper
import com.oktfolio.kite.mapper.RoleMapper
import com.oktfolio.kite.mapper.UserMapper
import com.oktfolio.kite.mapper.UserRoleMapper
import com.oktfolio.kite.model.UserDO
import com.oktfolio.kite.security.model.ExtendedUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/17
 */
@Service
class UserDetailsServiceImpl : ExtendedUserDetailsService {

    @Autowired
    private lateinit var userMapper: UserMapper

    @Autowired
    private lateinit var roleMapper: RoleMapper

    @Autowired
    private lateinit var userRoleMapper: UserRoleMapper

    @Autowired
    private lateinit var roleAuthorityMapper: RoleAuthorityMapper

    override fun loadUserByPhone(phone: String?): UserDetails {
        val user = userMapper.selectByPhone(phone)
        val authorityList = loadUserRoleAndAuthorityByUserDetails(user)
        return ExtendedUserDetails(
                user.id,
                user.username,
                user.mobile,
                user.email,
                user.password,
                authorityList)
    }

    override fun loadUserByEmail(email: String?): UserDetails {
        val user = userMapper.selectByEmail(email)
        val authorityList = loadUserRoleAndAuthorityByUserDetails(user)
        return ExtendedUserDetails(
                user.id,
                user.username,
                user.mobile,
                user.email,
                user.password,
                authorityList)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userMapper.selectByUsername(username)
        val authorityList = loadUserRoleAndAuthorityByUserDetails(user)
        return ExtendedUserDetails(
                user.id,
                user.username,
                user.mobile,
                user.email,
                user.password,
                authorityList)
    }

    private fun loadUserRoleAndAuthorityByUserDetails(userDO: UserDO): List<String> {
        val roleCodeList = userRoleMapper.selectRoleCodeListByUserId(userDO!!.id!!)
        val roleCodeListEnabled = roleMapper.selectRoleCodeListByRoleCodeListAndStatus(roleCodeList,
                Constants.RoleStatusEnum.ENABLED.value)
        val authorityCodeList = roleAuthorityMapper.selectAuthorityCodeListByRoleCodeList(roleCodeListEnabled)
        val authorityList = arrayListOf<String>()
        authorityList.addAll(roleCodeListEnabled)
        authorityList.addAll(authorityCodeList)
        authorityList.add(AuthorityEnum.ADMIN_USER_CREATE.code())
        return authorityList
    }

}