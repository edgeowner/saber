package com.demo.saber.infrastructure.mapper;

import com.demo.saber.infrastructure.po.UserCount;
import com.demo.saber.infrastructure.po.UserCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCountMapper {
    long countByExample(UserCountExample example);

    int deleteByExample(UserCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCount record);

    int insertSelective(UserCount record);

    List<UserCount> selectByExample(UserCountExample example);

    UserCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCount record, @Param("example") UserCountExample example);

    int updateByExample(@Param("record") UserCount record, @Param("example") UserCountExample example);

    int updateByPrimaryKeySelective(UserCount record);

    int updateByPrimaryKey(UserCount record);


    int addUserCount(UserCount userCount);
}