package com.demo.saber.infrastructure.mapper;

import com.demo.saber.infrastructure.po.PriceVersion;
import com.demo.saber.infrastructure.po.PriceVersionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangsunny
 */

public interface PriceVersionMapper {
    long countByExample(PriceVersionExample example);

    int deleteByExample(PriceVersionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PriceVersion record);

    int insertSelective(PriceVersion record);

    List<PriceVersion> selectByExample(PriceVersionExample example);

    PriceVersion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PriceVersion record, @Param("example") PriceVersionExample example);

    int updateByExample(@Param("record") PriceVersion record, @Param("example") PriceVersionExample example);

    int updateByPrimaryKeySelective(PriceVersion record);

    int updateByPrimaryKey(PriceVersion record);

    /**
     *
     * @desc  根据主键和版本号更新front字段
     *
     * @param priceVersion 价格版本号
     * @return
     */
    int updateByVersion(PriceVersion priceVersion);

    /**
     * @desc 批量插入数据
     *
     * @param priceVersions 价格版本号
     * @return
     */
    int batchInsertPriceVersions(@Param("list") List<PriceVersion> priceVersions);

}