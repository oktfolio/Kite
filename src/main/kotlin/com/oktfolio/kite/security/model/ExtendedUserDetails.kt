package com.oktfolio.kite.security.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/15
 */
class ExtendedUserDetails(
        var id: Long,
        private var username: String = "",
        var mobile: String? = "",
        var email: String? = "",
        private var password: String = "",
        private var authorities: List<String> = arrayListOf()) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        println(authorities.map { SimpleGrantedAuthority(it) })
        return authorities.map { SimpleGrantedAuthority(it) }
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return this.username
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return this.password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

}