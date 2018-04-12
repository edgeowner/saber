package com.demo.saber.infrastructure.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhangsunny
 */
@Data
public class Price {

    private Integer id;

    private BigDecimal total;

    private BigDecimal front;

    private BigDecimal end;

    private Date addTime;

    private Date updateTime;


}