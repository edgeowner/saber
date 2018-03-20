package com.demo.saber.infrastructure.mapper;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:/config/appcontext-*.xml",
        "classpath*:/mybatis-config.xml",
})
public class BaseTest{
    private static String path;

    @AfterClass
    public static void tearDown() throws Exception {
    }

    @Test
    public void doNothing() {
    }
}