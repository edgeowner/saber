package com.demo.saber.infrastructure.mapper;

import com.demo.saber.infrastructure.po.User;
import com.demo.saber.utils.ThreadPool;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zhangsunny on 2017/11/22.
 */
@Slf4j
public class UserMapperTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAllUser() throws Exception {
        List<User> allUser = userMapper.getAllUser();
//        System.out.println(new Gson().toJson(allUser));
        log.info(MessageFormat.format("allUser:{0}", new Gson().toJson(allUser)));
    }


    private class UserCallable implements Callable<Integer> {
        private List<User> list;
        private Integer j;

        public UserCallable(List<User> list, Integer j) {
            this.list = list;
            this.j = j;
        }


        @Override
        public Integer call() throws Exception {
            return batchInsertUser(list, j);
        }
    }


    @Test
    public void insertList() throws Exception {


        List<User> list = Lists.newArrayList();
        User user;
        String str = "skymoon";
        StringBuilder sb;
        for (int i = 0; i <= 200000; i++) {
            sb = new StringBuilder();
            user = new User();
            user.setIsValid(0);
            user.setLoginCode(String.valueOf(i));
            user.setLoginName(sb.append(str).append(i).toString());
            list.add(user);
        }
        List<List<User>> listList = Lists.partition(list, 500);
        ExecutorService executorPool = Executors.newCachedThreadPool();
        List<UserCallable> tasks = new ArrayList<>(listList.size());
        for (int i = 0; i < listList.size(); i++) {
            tasks.add(new UserCallable(listList.get(i), i));
        }

        List<Future<Integer>> futures = executorPool.invokeAll(tasks);
        int insertCount = 0;
        for (Future<Integer> future : futures) {
            insertCount += future.get(); // 返回任务的结果
        }
        System.out.println("insertCount: " + insertCount);
        executorPool.shutdown(); // 向线程池发送关闭的指令
    }

    private int batchInsertUser(List<User> users, int j) {
        log.info(MessageFormat.format("batchInsertUser start :{0}", j));
        if (CollectionUtils.isEmpty(users)) {
            return 0;
        }
        return userMapper.batchInsertUser(users);
    }

    @Test
    public void testInsert() {
        List<User> list = Lists.newArrayList();
        User user = new User();
        user.setLoginName("11");
        user.setLoginCode("11");
        user.setIsValid(1);
        list.add(user);
        batchInsertUser(list, 1);
    }

}