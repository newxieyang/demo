package com.cullen.demo.studyThread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncTest {




    public static void main(String[] args) {

        //  线程池 {}
        ExecutorService executorService = Executors.newFixedThreadPool(3000);

        Business business = new Business();

        for (int i = 0; i < 100000; i++) {
//            Thread thread = new Thread(() -> {
//
//                synchronized (business) {
//                    business.inc2();
//                }
//
//s
//            });


            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    business.inc2();
                }
            });

            executorService.submit(thread1);

        }



        try {
            Thread.sleep(10000);
            executorService.shutdown();

            System.out.println("end" + business.getJ());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("end" + business.j);


    }




}
