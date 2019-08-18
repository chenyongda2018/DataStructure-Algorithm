package JVM;

import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatile {

    private static final int THREAD_COUNT = 20;
//    private static volatile int num = 0;
    public static AtomicInteger num = new AtomicInteger(0);
    public static void increase() {
        num.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }

                }
            });
            threads[i].start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(num);
    }
}
