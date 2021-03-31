package com.cullen.demo;

import com.cullen.demo.service.RPCService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

/**
 * @author 谢洋  newxieyang@msn.cn
 * @Date: 2019/3/20 21:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadsTest {


    @Resource
    public RPCService orderService;

    int num = 1000;

    CountDownLatch countDownLatch = new CountDownLatch(num);


//    private  void add() {
//        a = a + 1;
//    }

    @Test
    public void testInterface() {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {

                try {
                    Map<String, Object> map = orderService.queryOrderInfos("123");
                    System.out.println("result:" + map);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

            executorService.submit(thread);



        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
