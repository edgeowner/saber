package com.demo.saber.mgt.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhangsunny
 * @Date 2018-04-12
 */
@Data
public class PriceVersionDto {
    private Integer id;

    private BigDecimal total;

    private BigDecimal front;

    private BigDecimal end;

    private Integer version;
}
