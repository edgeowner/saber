package com.demo.saber.application;


import com.demo.saber.mgt.dto.PriceDto;

/**
 * @author zhangsunny
 */
public interface PriceApplication {

    void updatePriceByDto(PriceDto priceDto);


    void getPriceByKey(Integer key);


}
