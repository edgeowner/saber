package com.demo.saber.mgt.impl;

import com.demo.saber.infrastructure.mapper.PriceMapper;
import com.demo.saber.infrastructure.po.Price;
import com.demo.saber.mgt.PriceMgt;
import com.demo.saber.mgt.dto.PriceDto;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * @author zhangsunny
 * @Date 2018-04-10
 */
@Slf4j
@Service
public class PriceMgtImpl implements PriceMgt {

    @Autowired
    private PriceMapper priceMapper;

    @Override
    public void updatePriceByDto(PriceDto dto) {

        Price toUpdatePrice = new Price();
        BeanUtils.copyProperties(dto, toUpdatePrice);

        if (toUpdatePrice == null) {
            Gson gson = new Gson();
            log.info(MessageFormat.format("updatePriceByDto Prama :{0}", gson.toJson(dto)));
            return;
        }
        priceMapper.updateByPrimaryKey(toUpdatePrice);
    }
}
