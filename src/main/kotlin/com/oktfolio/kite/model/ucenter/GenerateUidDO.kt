package com.oktfolio.kite.model.ucenter

import com.baomidou.mybatisplus.annotation.TableName
import com.oktfolio.kite.model.BaseModel

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/04/23
 */
@TableName("kite_generate_uid")
data class GenerateUidDO(var snowflake: Long) : BaseModel()