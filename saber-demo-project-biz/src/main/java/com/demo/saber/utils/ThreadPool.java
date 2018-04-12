package com.demo.saber.utils;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangsunny
 * @Date 2018-04-10
 */
@Slf4j

public class ThreadPool {

    private static ThreadPoolExecutor POOL;


    private final static int MAX_SIZE = 50;
    private final static int INIT_SIZE = 10;
    private final static int IDEL_TIME = 1;
    private final static int MAX_QUEUE_SIZE = 200;

    /**
     * 根据线程名称初始化线程池(Thread方式实现)
     *
     * @param thread
     * @param threadName
     */
    public static void execute(Thread thread, String threadName) {
        if (thread == null) {
            thread.setName(threadName);
        }
        if (POOL == null) {
            init();
        }

        if (!POOL.isTerminating() || !POOL.isTerminated()) {
            POOL.execute(thread);
        } else {
            log.error("pool is terminating, refuse to execute thread any more");
        }

    }


    /**
     * Runnalbe实现线程池的初始化
     *
     * @param runnable
     */
    public static void execute(Runnable runnable) {
        if (runnable == null) {
            log.error("thread is null, return at once");
        }
        if (POOL == null) {
            init();
        }
        if (!POOL.isTerminating() || !POOL.isTerminated()) {
            POOL.execute(runnable);
        } else {
            log.error("pool is terminating, refuse to execute thread any more");
        }
    }

    public void destroy() {
        log.info("thread pool is destroying");
        if (POOL != null) {
            POOL.shutdown();
            try {
                if (!POOL.awaitTermination(60, TimeUnit.SECONDS)) {
                    log.info("thread pool is terminate now");
                    POOL.shutdown();
                }
            } catch (InterruptedException ex) {
                POOL.shutdown();
                Thread.currentThread().interrupt();
            }
        }
    }

    private synchronized static void init() {
        log.info("thread pool is init ");
        if (POOL == null) {
            POOL = new ThreadPoolExecutor(INIT_SIZE, MAX_SIZE,
                    IDEL_TIME, TimeUnit.MINUTES,
                    new ArrayBlockingQueue<Runnable>(MAX_QUEUE_SIZE, true),
                    new ThreadPoolExecutor.CallerRunsPolicy());
        }
    }

}
