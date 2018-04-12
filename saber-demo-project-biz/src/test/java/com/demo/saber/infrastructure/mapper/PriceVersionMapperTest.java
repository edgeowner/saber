package com.demo.saber.infrastructure.mapper;

import com.demo.saber.infrastructure.po.Price;
import com.demo.saber.infrastructure.po.PriceVersion;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;


public class PriceVersionMapperTest extends BaseTest {


    @Autowired
    private PriceVersionMapper priceVersionMapper;


    @Test
    public void insertTest() {
        List<PriceVersion> toInsertList = Lists.newArrayList();
        int front, end, total = 0;
        for (int i = 1; i < 100; i++) {
            PriceVersion priceVersion = new PriceVersion();
            front = i;
            total = 100;
            end = total - front;
            priceVersion.setFront(new BigDecimal(front));
            priceVersion.setEnd(new BigDecimal(end));
            priceVersion.setTotal(new BigDecimal(total));
            priceVersion.setVersion(i);
            toInsertList.add(priceVersion);
        }
        priceVersionMapper.batchInsertPriceVersions(toInsertList);

    }


    @Test
    public void updateByVersion() {
        PriceVersion priceVersion = new PriceVersion();
        priceVersion.setFront(new BigDecimal(10));
        priceVersion.setVersion(1);
        priceVersion.setId(1);
        int count = priceVersionMapper.updateByVersion(priceVersion);
        System.out.println(MessageFormat.format("count:{0}", count));
    }
}