package com.demo.saber.mgt.impl;

import com.demo.saber.infrastructure.mapper.UserMapper;
import com.demo.saber.infrastructure.po.User;
import com.demo.saber.mgt.UserMgt;
import com.demo.saber.mgt.dto.UserDto;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by zhangsunny on 2017/9/30.
 */
@Slf4j
@Service
public class UserMgtImpl implements UserMgt {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getUserList() {
        List<User> allUser = userMapper.getAllUser();
        List<UserDto> userList = Lists.transform(allUser, new Function<User, UserDto>() {
            @Override
            public UserDto apply(User input) {
                UserDto userDto = new UserDto();
                userDto.setLoginCode(input.getLoginCode());
                userDto.setLoginName(input.getLoginName());
                return userDto;
            }
        });

        log.info(MessageFormat.format("数据获取：{0}",new Gson().toJson(userList)));
        return userList;
    }
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");
    }
}
