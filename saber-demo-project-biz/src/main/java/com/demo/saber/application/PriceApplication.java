package com.demo.saber.application;


import com.demo.saber.application.vo.PriceVO;
import com.demo.saber.mgt.dto.PriceDto;

/**
 * @author zhangsunny
 */
public interface PriceApplication {

    void updatePriceByDto(PriceDto priceDto);

}
