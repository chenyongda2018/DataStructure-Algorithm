import 修饰符.Person;

import java.util.concurrent.*;

/**
 * Created by cyd on 19-4-8.
 */

public class Test {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<Integer> task = threadPool.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 1;
            }
        });
        System.out.println("主线程在执行");
        try {
            if(task.get() .equals(1)) {
                System.out.println("task执行结束");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
