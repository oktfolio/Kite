package com.oktfolio.kite.security.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/17
 */
interface ExtendedUserDetailsService : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    fun loadUserByPhone(phone: String?): UserDetails

    @Throws(UsernameNotFoundException::class)
    fun loadUserByEmail(email: String?): UserDetails
}