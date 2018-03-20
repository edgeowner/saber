package com.demo.saber.application;



import com.demo.saber.mgt.dto.UserDto;

import java.util.List;

/**
 * Created by zhangsunny on 2017/9/30.
 */

public interface UserApplication {
    List<UserDto> getUserList();
}
