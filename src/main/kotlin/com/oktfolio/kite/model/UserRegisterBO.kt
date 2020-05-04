package com.oktfolio.kite.model


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/04/29
 */
data class UserRegisterBO(var username: String,
                          var email: String,
                          var mobile: String,
                          var password: String,
                          var verificationCode: String)