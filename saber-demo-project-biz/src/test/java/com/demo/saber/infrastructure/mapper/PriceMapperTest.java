package com.demo.saber.infrastructure.mapper;

import com.demo.saber.infrastructure.po.Price;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


public class PriceMapperTest extends BaseTest{

    @Autowired
    private PriceMapper priceMapper;

    @Test
    public void insertSelective() {
        Price price = new Price();
        price.setFront(new BigDecimal(1111));
        priceMapper.insertSelective(price);
    }
}