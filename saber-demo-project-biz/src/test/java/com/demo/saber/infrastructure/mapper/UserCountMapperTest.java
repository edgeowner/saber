package com.demo.saber.infrastructure.mapper;

import com.demo.saber.infrastructure.po.UserCount;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by zhangsunny on 2017/11/22.
 */
public class UserCountMapperTest extends BaseTest {


    @Autowired
    private UserCountMapper userCountMapper;

    @Test
    public void addUserCountTest() throws Exception {
        UserCount userCount = new UserCount();
        userCount.setCountTime(new Date());
        userCount.setUserCount(1);
        int key = userCountMapper.addUserCount(userCount);
        System.out.printf("key1"+key);
    }

}