package com.demo.saber.application.impl;

import com.demo.saber.application.UserApplication;
import com.demo.saber.mgt.UserMgt;
import com.demo.saber.mgt.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by zhangsunny on 2017/9/30.
 */
@Slf4j
@Component
public class UserApplicationImpl implements UserApplication {

    @Autowired
    private UserMgt userMgt;

    @Override
    public List<UserDto> getUserList() {
        return userMgt.getUserList();
    }

}
