package com.demo.saber.web.controller.user;

import com.demo.saber.application.UserApplication;
import com.demo.saber.mgt.dto.UserDto;
import com.demo.saber.web.webutils.WebUtil;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangsunny on 2017/9/30.
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserApplication userApplication;

    @RequestMapping(value = "/saber/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> loginUser() {
        List<UserDto> userList = userApplication.getUserList();
        log.info(MessageFormat.format("step1:{0}",new Gson().toJson(userList)));
        return WebUtil.result(userList);
    }

    public static void main(String[] args) {
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");
    }

}
