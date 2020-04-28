package com.oktfolio.kite.mapper

import com.oktfolio.kite.model.RoleDO
import tk.mybatis.mapper.common.BaseMapper
import tk.mybatis.mapper.common.MySqlMapper


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/04/23
 */
interface GenerateUIDMapper : BaseMapper<RoleDO>, MySqlMapper<RoleDO> {
}