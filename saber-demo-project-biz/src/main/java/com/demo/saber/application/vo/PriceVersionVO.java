package com.demo.saber.application.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceVersionVO {
    private Integer id;

    private BigDecimal total;

    private BigDecimal front;

    private BigDecimal end;

    private Integer version;
}
