package com.oktfolio.kite.model.ucenter

import com.oktfolio.kite.model.BaseModel

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
class Role : BaseModel() {

    private var id: Int? = null
    private var name: String? = null
    private var code: String? = null
    private var status: Int? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getCode(): String? {
        return code
    }

    fun setCode(code: String?) {
        this.code = code
    }

    fun getStatus(): Int? {
        return status
    }

    fun setStatus(status: Int?) {
        this.status = status
    }
}
