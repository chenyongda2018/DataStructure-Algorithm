package TestThreadPool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProduceConsumer {
    Object lock = new Object();

    Lock lock1 = new ReentrantLock();
    Condition c1 = lock1.newCondition();

    int num = 0;



    //加1
    void increament() {
        System.out.println();
        synchronized (lock) {
            //用while,不用if 是为了防止虚假唤醒
            while(num != 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num++;
            lock.notifyAll();
        }
    }

    //减1
    void decreament() {
        synchronized (lock) {
            while(num == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num--;
            lock.notifyAll();
        }
    }


    public static void main(String[] args) {
        ProduceConsumer p = new ProduceConsumer();
        for (int i = 0; i < 5; i++) {
            int  j = i+1;
            new Thread(() -> {

                System.out.println("第"+(j) + "轮");
                p.increament();
                System.out.println(Thread.currentThread().getName() + " -- " + p.num);
            }, "thread 1").start();
            new Thread(() -> {
                p.decreament();
                System.out.println(Thread.currentThread().getName() + " -- " + p.num);
            }, "thread 2").start();

        }

        while(Thread.activeCount() > 2) {

        }
        System.out.println("main thread " + p.num);
    }
}
