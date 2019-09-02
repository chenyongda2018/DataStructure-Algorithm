package TestThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 带有返回值的run方法
 */
public class TestCallable {
    public static void main(String[] args) {
        FutureTask task1 = new FutureTask(new T1());
        Thread thread = new Thread(task1,"t1");
        thread.start();
        try {
            System.out.println(task1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class T1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 111;
    }
}