package com.oktfolio.kite.security.config

import com.oktfolio.kite.security.filter.JsonUsernamePasswordAuthenticationFilter
import com.oktfolio.kite.security.handlers.AccessDeniedHandlerImpl
import com.oktfolio.kite.security.handlers.AuthenticationFailureHandlerImpl
import com.oktfolio.kite.security.handlers.AuthenticationSuccessHandlerImpl
import com.oktfolio.kite.security.service.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils
import javax.servlet.http.HttpServletRequest

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/15
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig : WebSecurityConfigurerAdapter(false) {

    @Autowired
    private lateinit var userDetailsService: UserDetailsServiceImpl

    @Autowired
    private lateinit var authenticationSuccessHandlerImpl: AuthenticationSuccessHandlerImpl

    @Autowired
    private lateinit var authenticationFailureHandlerImpl: AuthenticationFailureHandlerImpl

    @Autowired
    private lateinit var accessDeniedHandlerImpl: AccessDeniedHandlerImpl

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Bean
    fun daoAuthenticationProvider(): DaoAuthenticationProvider? {
        val provider = DaoAuthenticationProvider()
        // passwordEncoder
        provider.setPasswordEncoder(passwordEncoder)
        // username UserDetailsService
        provider.setUserDetailsService(userDetailsService)
        // setHideUserNotFoundExceptions
        provider.isHideUserNotFoundExceptions = false
        return provider
    }

    @Bean
    @Throws(java.lang.Exception::class)
    fun jsonUsernamePasswordAuthenticationFilter(): JsonUsernamePasswordAuthenticationFilter? {
        val filter = JsonUsernamePasswordAuthenticationFilter()
        filter.setAuthenticationManager(authenticationManagerBean())
        filter.setFilterProcessesUrl("/login")
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandlerImpl)
        filter.setAuthenticationFailureHandler(authenticationFailureHandlerImpl)
        return filter
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(daoAuthenticationProvider())
    }

    override fun configure(http: HttpSecurity) {

        // csrf
        http.csrf().disable()

        http.userDetailsService(userDetailsService)

        // grant all preflight request
        http.authorizeRequests()
                .requestMatchers(RequestMatcher { request: HttpServletRequest? ->
                    CorsUtils.isPreFlightRequest(request!!)
                })
                .permitAll()

//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()

//        http.authorizeRequests()
//                .anyRequest()
//                .denyAll()

        // access denied handler
        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandlerImpl)

        // json username password authentication filter
        http.addFilterAt(
                jsonUsernamePasswordAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter::class.java)

        http.formLogin()
                .successHandler(authenticationSuccessHandlerImpl)
                .failureHandler(authenticationFailureHandlerImpl)
    }
}