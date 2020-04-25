package com.oktfolio.kite.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.oktfolio.kite.model.ucenter.RoleDO
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository


/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/03/21
 */
@Repository
interface RoleMapper : BaseMapper<RoleDO> {
    fun selectRoleListByRoleCodeAndStatus(@Param("code") code: String,
                                          @Param("status") status: Int)

    fun selectRoleCodeListByRoleCodeListAndStatus(@Param("codeList") codeList: List<String>,
                                                  @Param("status") status: Int): List<String>

}