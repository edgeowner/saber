package com.demo.saber.mgt.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhangsunny
 */
@Data
public class PriceDto {

    private Integer id;

    private BigDecimal total;

    private BigDecimal front;

    private BigDecimal end;

}
