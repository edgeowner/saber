package com.demo.saber.application.impl;

import com.demo.saber.application.PriceVersionApplication;
import com.demo.saber.infrastructure.po.PriceVersion;
import com.demo.saber.mgt.PriceVersionMgt;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class PriceVesionApplicationImpl implements PriceVersionApplication {


    @Autowired
    private PriceVersionMgt priceVersionMgt;

    @Override
    public int updatePriceVersionByVersion(PriceVersion priceVersion) {
        return priceVersionMgt.updatePriceByVersion(priceVersion);
    }
}
