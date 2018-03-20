package com.demo.saber.infrastructure.mapper;

import com.demo.saber.infrastructure.po.User;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhangsunny on 2017/11/22.
 */
@Slf4j
public class UserMapperTest extends BaseTest{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAllUser() throws Exception {
        List<User> allUser = userMapper.getAllUser();
//        System.out.println(new Gson().toJson(allUser));
        log.info(MessageFormat.format("allUser:{0}",new Gson().toJson(allUser)));
    }

}