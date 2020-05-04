package com.oktfolio.kite.security.authentication

import com.oktfolio.kite.common.constant.Constants.VerificationCode.PHONE
import com.oktfolio.kite.security.exceptions.InvalidVerificationCodeException
import com.oktfolio.kite.security.service.ExtendedUserDetailsService
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.security.authentication.InternalAuthenticationServiceException
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.util.Assert


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/05/04
 */
class PhoneAuthenticationProvider : AbstractPhoneUserDetailsAuthenticationProvider() {
    private var userDetailsService: ExtendedUserDetailsService? = null
    private var stringRedisTemplate: StringRedisTemplate? = null

    @Throws(AuthenticationException::class)
    override fun additionalAuthenticationChecks(userDetails: UserDetails?, authentication: PhoneAuthenticationToken) {
        logger.info("additionalAuthenticationChecks")
        val principal = authentication.getPrincipal()
        val s = stringRedisTemplate!!.opsForValue()[PHONE + principal]
        logger.info("$PHONE$principal = $s")
        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: verification code null")
            throw InvalidVerificationCodeException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.invalidVerificationCode", "verification code null"))
        } else if (authentication.getCredentials().toString() != s) {
            logger.debug("Authentication failed: invalid verification code")
            throw InvalidVerificationCodeException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.invalidVerificationCode", "invalid verification code"))
        }
        stringRedisTemplate!!.delete(PHONE + principal)
    }

    override fun doAfterPropertiesSet() {
        Assert.notNull(userDetailsService, "A UserDetailsService must be set")
    }

    @Throws(AuthenticationException::class)
    override fun retrieveUser(email: String?, authentication: PhoneAuthenticationToken?): UserDetails {
        return try {
            val loadedUser = getUserDetailsService()!!.loadUserByPhone(email)
            loadedUser
                    ?: throw InternalAuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation")
        } catch (var4: UsernameNotFoundException) {
            throw var4
        } catch (var6: Exception) {
            throw InternalAuthenticationServiceException(var6.message, var6)
        }
    }

    override fun createSuccessAuthentication(principal: Any?, authentication: Authentication, user: UserDetails): Authentication {
        val result = PhoneAuthenticationToken(principal, authentication.credentials, user.authorities)
        result.details = authentication.details
        return result
    }

    fun setUserDetailsService(userDetailsService: ExtendedUserDetailsService?) {
        this.userDetailsService = userDetailsService
    }

    private fun getUserDetailsService(): ExtendedUserDetailsService? {
        return userDetailsService
    }

    private fun getStringRedisTemplate(): StringRedisTemplate? {
        return stringRedisTemplate
    }

    fun setStringRedisTemplate(stringRedisTemplate: StringRedisTemplate?) {
        this.stringRedisTemplate = stringRedisTemplate
    }
}