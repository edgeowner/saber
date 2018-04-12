package com.demo.saber.infrastructure.mapper;

import com.demo.saber.infrastructure.po.Price;
import com.demo.saber.infrastructure.po.PriceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author zhangsunny
 */
public interface PriceMapper {
    long countByExample(PriceExample example);

    int deleteByExample(PriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Price record);

    int insertSelective(Price record);

    List<Price> selectByExample(PriceExample example);

    Price selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByExample(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByPrimaryKeySelective(Price record);

    int updateByPrimaryKey(Price record);

    int batchInsertPrices(@Param("list") List<Price> toInsertList);
}