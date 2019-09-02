package TestThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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


}
