package com.demo.saber.job;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.MessageFormat;

/**
 * Created by zhangsunny on 2017/11/21.
 */
@Slf4j
public class DemoJob implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info(MessageFormat.format("\n=======Job:{0}", "start\n"));
        System.out.printf( "\n =========Job start========\n");
    }
}
