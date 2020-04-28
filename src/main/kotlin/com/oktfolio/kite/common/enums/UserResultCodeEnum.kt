package com.oktfolio.kite.common.enums

import com.oktfolio.kite.common.enums.ResultCode

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/16
 */
enum class UserResultCodeEnum(private val value: Int,
                              private val message: String) : ResultCode {
    // failed to delete user roles
    FAILED_DELETE_USER_ROLES(400030, "failed to delete user roles"),
    // failed to add user roles
    FAILED_ADD_USER_ROLES(400031, "failed to add user roles"),
    // failed create user
    FAILED_CREATE_USER(400020, "failed to create user"),
    // failed delete user
    FAILED_DELETE_USER(400021, "failed to delete user"),
    // failed update user
    FAILED_UPDATE_USER(400022, "failed to update user"),
    // failed update user password
    FAILED_UPDATE_USER_PASSWORD(400022, "failed to update user password"),
    // username exists
    USERNAME_EXISTS(400010, "username already registered"),
    // email exists
    EMAIL_EXISTS(400011, "email has been bound by other user"),
    // phone exists
    PHONE_EXISTS(400012, "phone has been bound by other user"),
    // username or password cannot be null
    USERNAME_PASSWORD_CANNOT_BE_NULL(401010, "username or password cannot be null"),
    // bad username or password
    BAD_USERNAME_PASSWORD(401011, "bad username or password"),
    // user not exist
    USER_NOT_EXIST(401012, "bad not exist"),
    // invalid login status
    INVALID_LOGIN_STATUS(401113, "invalid login status, please re login"),
    // invalid token
    INVALID_TOKEN(401014, "invalid token"),
    // user expired
    USER_EXPIRED(401015, "uer expired"),
    // user locked or disabled
    USER_LOCKED(401016, "user locked or disabled"),
    // credentials expired
    CREDENTIALS_EXPIRED(401017, "credentials expired"),
    // user disabled
    USER_DISABLED(401018, "user disabled"),
    // failed login
    FAILED_LOGIN(401019, "failed login"),
    // bad verification code
    INVALID_VERIFICATION_CODE(401020, "invalid verification code"),
    // bad old password
    BAD_OLD_PASSWORD(401021, "bad old password");

    override fun value(): Int {
        return value
    }

    override fun message(): String {
        return message
    }

}
