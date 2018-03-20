package com.demo.saber.web.controller;

import com.demo.saber.web.webutils.WebUtil;
import com.google.common.collect.Lists;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangsunny on 2017/9/26.
 */

@Slf4j
@Controller
public class IndexController {

    @RequestMapping(value = "/saber/index", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> indexDebug() {
        log.info(MessageFormat.format("\n/saber/index\n:{0}", "hahaha"));
        System.out.println("\n/saber/index\n:{0} ");
        return WebUtil.success();
    }


    public static void main(String[] args) {
        List<Integer> sumcount = Lists.newArrayList();
        sumcount.add(1);
        sumcount.add(2);
        sumcount.add(3);
        sumcount.add(4);
        sumcount.add(5);

        Integer sum = 0;
        final Integer sum2;
//        sumcount.stream().forEach((Integer i) -> {
//            sum = sum + i;
//        });
        System.out.println(sum);

    }

}
