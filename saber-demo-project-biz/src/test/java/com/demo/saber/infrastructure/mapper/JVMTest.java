package com.demo.saber.infrastructure.mapper;




import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JVMTest extends BaseTest {


    private static Logger LOGGER = LogManager.getLogger(JVMTest.class.getName());

    public static void getTest(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
        String today = sdf.format(new Date());
        LOGGER.info(today + "：" + msg);

    }

    public static void main(String[] args) {
        getTest("Hello JVM");
    }
}
