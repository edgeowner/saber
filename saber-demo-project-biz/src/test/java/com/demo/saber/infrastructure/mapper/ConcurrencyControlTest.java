package com.demo.saber.infrastructure.mapper;

import com.demo.saber.infrastructure.po.Price;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class ConcurrencyControlTest extends BaseTest {

    @Autowired
    private PriceMapper priceMapper;


    @Test
    public void insertTest() {
        List<Price> toInsertList = Lists.newArrayList();
        int front, end, total = 0;
        for (int i = 1; i < 100; i++) {
            Price price = new Price();
            front =  i;
            total = 100;
            end = total - front;
            price.setFront(new BigDecimal(front));
            price.setEnd(new BigDecimal(end));
            price.setTotal(new BigDecimal(total));
            toInsertList.add(price);
        }
        priceMapper.batchInsertPrices(toInsertList);

    }

    @Test
    public void singleCounsumerTest() {

        for (int i = 0; i < 100; i++) {
            Price price = priceMapper.selectByPrimaryKey(1);
            int ron = 10;
            price.setFront(price.getFront().subtract(new BigDecimal(ron)));
            price.setEnd(price.getEnd().add(new BigDecimal(ron)));
            price.setTotal(price.getFront().add(price.getEnd()));

            priceMapper.updateByPrimaryKey(price);
            price.setId(null);
            priceMapper.insertSelective(price);
        }
    }




}
