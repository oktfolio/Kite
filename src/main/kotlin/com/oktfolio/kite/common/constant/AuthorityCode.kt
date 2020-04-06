package com.oktfolio.kite.common.constant


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
interface AuthorityCode {
    interface AdminUser {
        companion object {
            const val CREATE = "ADMIN_USER_LIST_CREATE"
            const val HAS_AUTHORITY_CREATE = "hasAuthority('$CREATE')"
            const val DELETE = "ADMIN_USER_LIST_DELETE"
            const val HAS_AUTHORITY_DELETE = "hasAuthority('$DELETE')"
            const val UPDATE = "ADMIN_USER_LIST_UPDATE"
            const val HAS_AUTHORITY_UPDATE = "hasAuthority('$UPDATE')"
            const val RETRIEVE = "ADMIN_USER_LIST_RETRIEVE"
            const val HAS_AUTHORITY_RETRIEVE = "hasAuthority('$RETRIEVE')"
        }
    }
}