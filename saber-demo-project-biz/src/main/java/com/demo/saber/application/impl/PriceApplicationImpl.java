package com.demo.saber.application.impl;

import com.demo.saber.application.PriceApplication;
import com.demo.saber.mgt.PriceMgt;
import com.demo.saber.mgt.dto.PriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangsunny
 * @Date 2018-04-10
 */
@Slf4j
@Component
public class PriceApplicationImpl implements PriceApplication {

    @Autowired
    private PriceMgt priceMgt;



//    @Transactional
    @Override
    public void updatePriceByDto(PriceDto priceDto) {
        priceMgt.updatePriceByDto(priceDto);
    }

    @Override
    public void getPriceByKey(Integer key) {

    }
}
