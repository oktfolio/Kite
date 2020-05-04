package com.oktfolio.kite.model


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
class RoleDO : BaseModel() {

    private var name: String? = null
    private var code: String? = null
    private var dataScope: Int? = null
    private var level: Int? = null
    private var status: Int? = null
    private var remark: Int? = null

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
