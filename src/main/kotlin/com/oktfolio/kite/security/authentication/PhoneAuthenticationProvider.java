package com.oktfolio.kite.security.authentication;


import com.oktfolio.kite.security.exceptions.InvalidVerificationCodeException;
import com.oktfolio.kite.security.service.ExtendedUserDetailsService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/02/27
 */
public class PhoneAuthenticationProvider extends AbstractPhoneUserDetailsAuthenticationProvider {

    private ExtendedUserDetailsService userDetailsService;

    private StringRedisTemplate stringRedisTemplate;

    private static final String PREFIX = "VERIFICATION_CODE:PHONE:";

    public PhoneAuthenticationProvider() {
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, PhoneAuthenticationToken authentication) throws AuthenticationException {
        logger.info("additionalAuthenticationChecks");

        String s = stringRedisTemplate.opsForValue().get(PREFIX + "oktfolio@gmail.com");

        logger.info(PREFIX + "oktfolio@gmail.com" + " = " + s);

        if (authentication.getCredentials() == null) {
            this.logger.debug("Authentication failed: verification code null");
            throw new InvalidVerificationCodeException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.invalidVerificationCode", "verification code null"));
        } else if (!authentication.getCredentials().toString().equals(s)) {
            this.logger.debug("Authentication failed: invalid verification code");
            throw new InvalidVerificationCodeException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.invalidVerificationCode", "invalid verification code"));
        }

        stringRedisTemplate.delete(PREFIX + "oktfolio@gmail.com");
    }

    @Override
    protected void doAfterPropertiesSet() {
        Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
    }

    @Override
    protected final UserDetails retrieveUser(String email, PhoneAuthenticationToken authentication) throws AuthenticationException {
        try {
            UserDetails loadedUser = this.getUserDetailsService().loadUserByPhone(email);
            if (loadedUser == null) {
                throw new InternalAuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
            } else {
                return loadedUser;
            }
        } catch (UsernameNotFoundException var4) {
            throw var4;
        } catch (Exception var6) {
            throw new InternalAuthenticationServiceException(var6.getMessage(), var6);
        }
    }

    @Override
    protected Authentication createSuccessAuthentication(Object principal, Authentication authentication, UserDetails user) {
        PhoneAuthenticationToken result = new PhoneAuthenticationToken(principal, authentication.getCredentials(), user.getAuthorities());
        result.setDetails(authentication.getDetails());
        return result;
    }

    public void setUserDetailsService(ExtendedUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    protected ExtendedUserDetailsService getUserDetailsService() {
        return this.userDetailsService;
    }

    protected StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
}
