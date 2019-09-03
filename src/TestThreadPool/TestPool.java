package TestThreadPool;

import java.util.concurrent.*;

public class TestPool {
    //固定个数的线程
    //适用 : 执行长期的异步操作
    ExecutorService fixThreadPool = Executors.newFixedThreadPool(5);
    //最大容纳Integer.MAX_VALUE个线程
    //适用 : 执行一些短期的异步操作
    ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
    //单个线程
    //适用 : 只能有一个线程来处理任务
    ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();


    //自定义线程池
    static ExecutorService myThreadPool = new ThreadPoolExecutor(
            2,
            5,
            1L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy()
    );

    public static void main(String[] args) {
//        try {
//            for (int i = 0; i < 11; i++) {
//                myThreadPool.execute(() -> {
//                    System.out.println(Thread.currentThread().getName()+"- 办理");
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } );
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


}
