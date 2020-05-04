package com.oktfolio.kite.model;

import java.time.LocalDateTime;

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/05/04
 */
public class BaseModel {
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
