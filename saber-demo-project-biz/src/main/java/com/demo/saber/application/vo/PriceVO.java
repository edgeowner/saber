package com.demo.saber.application.vo;

import lombok.Data;

import java.math.BigDecimal;


/**
 * @author zhangsunny
 * @Date 2018-04-10
 */
@Data
public class PriceVO {

    private Integer id;

    private BigDecimal total;

    private BigDecimal front;

    private BigDecimal end;

}
