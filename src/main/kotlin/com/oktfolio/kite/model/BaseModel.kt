package com.oktfolio.kite.model

import java.time.LocalDateTime


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
open class BaseModel {
    private var gmtCreate: LocalDateTime? = null
    private var gmtModified: LocalDateTime? = null
}