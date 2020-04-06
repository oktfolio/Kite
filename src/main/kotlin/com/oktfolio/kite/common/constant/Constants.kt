package com.oktfolio.kite.common.constant


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
object Constants {
    enum class UserStatusEnum(val value: Int, val desc: String) {
        /**
         * 密码过期
         */
        CREDENTIAL_EXPIRED(4, "密码过期"),

        /**
         * 已锁定
         */
        LOCKED(3, "已锁定"),

        /**
         * 已过期
         */
        EXPIRED(2, "已过期"),

        /**
         * 已启用
         */
        ENABLED(1, "已启用"),

        /**
         * 未启用
         */
        DISABLED(0, "未启用"),

        /**
         * 已删除
         */
        DELETED(-1, "已删除");

    }

    enum class RoleStatusEnum(val value: Int, val desc: String) {
        /**
         * 已启用
         */
        ENABLED(1, "已启用"),

        /**
         * 未启用
         */
        DISABLED(0, "未启用");

    }
}