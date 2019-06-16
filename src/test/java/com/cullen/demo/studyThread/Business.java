package com.cullen.demo.studyThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Business {

    private int j = 0;

    Lock lock = new ReentrantLock();

    public void inc() {
        lock.lock();
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
        lock.unlock();
    }


    public synchronized  void inc1() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }


    public void inc2() {
        synchronized (this) {
            j++;
//            System.out.println(Thread.currentThread().getName() + "-inc:" + j);
        }

        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }


    public  void inc3() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }


    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
