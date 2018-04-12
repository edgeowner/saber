package com.demo.saber.mgt.impl;

import com.demo.saber.infrastructure.mapper.PriceVersionMapper;
import com.demo.saber.infrastructure.po.PriceVersion;
import com.demo.saber.mgt.PriceVersionMgt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author zhangsunny
 * @Date 2018-04-12
 */
@Slf4j
@Service
public class PriceVersionMgtImpl implements PriceVersionMgt {

    @Autowired
    private PriceVersionMapper priceVersionMapper;

    @Override
    public int updatePriceByVersion(PriceVersion priceVersion) {
        int result = priceVersionMapper.updateByVersion(priceVersion);

        if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
