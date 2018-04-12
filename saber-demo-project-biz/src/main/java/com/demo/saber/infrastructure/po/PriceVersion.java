package com.demo.saber.infrastructure.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhangsunny
 */
@Data
public class PriceVersion {
    private Integer id;

    private BigDecimal total;

    private BigDecimal front;

    private BigDecimal end;

    private Integer version;

    private Date addTime;

    private Date updateTime;

}