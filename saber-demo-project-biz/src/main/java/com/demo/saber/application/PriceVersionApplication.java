package com.demo.saber.application;

import com.demo.saber.infrastructure.po.PriceVersion;

import java.math.BigDecimal;

/**
 * @author zhangsunny
 * @Date 2018-04-12
 */
public interface PriceVersionApplication {

    /**
     * 根据主键ID、版本号乐观锁方式更新数据
     *
     * @param priceVersion
     * @return
     */
    int updatePriceVersionByVersion(PriceVersion priceVersion);
}
