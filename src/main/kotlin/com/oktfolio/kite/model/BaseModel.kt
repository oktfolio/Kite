package com.oktfolio.kite.model

import java.time.LocalDateTime


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
open class BaseModel {
    private var id: Long? = null;
    private var createTime: LocalDateTime? = null
    private var updateTime: LocalDateTime? = null
}