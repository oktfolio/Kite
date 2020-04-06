package com.oktfolio.kite.common.enums

import com.oktfolio.kite.common.AuthorityPool
import com.oktfolio.kite.common.constant.AuthorityCode

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/18
 */
enum class AuthorityEnum(private val code: String,
                         private val desc: String,
                         private val group: AuthorityGroupEnum) {

    ADMIN_USER_CREATE(
            AuthorityCode.AdminUser.CREATE,
            "管理_用户_列表_创建",
            AuthorityGroupEnum.ADMIN_USER),
    ADMIN_USER_DELETE(
            AuthorityCode.AdminUser.DELETE,
            "管理_用户_列表_删除",
            AuthorityGroupEnum.ADMIN_USER),
    ADMIN_USER_UPDATE(
            AuthorityCode.AdminUser.UPDATE,
            "管理_用户_列表_更新",
            AuthorityGroupEnum.ADMIN_USER),
    ADMIN_USER_RETRIEVE(
            AuthorityCode.AdminUser.RETRIEVE,
            "管理_用户_列表_查询",
            AuthorityGroupEnum.ADMIN_USER);


    fun code(): String {
        return code
    }

    fun desc(): String {
        return desc
    }

    fun group(): AuthorityGroupEnum {
        return group
    }

    fun hasAuthority(): String {
        return StringBuffer()
                .append("hasAuthority('")
                .append(code)
                .append("')")
                .toString()
    }

    init {
        AuthorityPool.putAuthority(code, name, group)
    }
}