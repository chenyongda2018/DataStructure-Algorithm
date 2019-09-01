package JVM;

import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatile {

    volatile int number = 0;//保证可见性，将值写回主内存,通知其他线程此值已经改变。

    public void addNumberto10() {
        this.number = 10;
    }


    public static void main(String[] args) {
        testSee();
    }

    /**
     * 测试volatile的可见性
     */
    private static void testSee() {
        TestVolatile test = new TestVolatile();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.addNumberto10();
            System.out.println(Thread.currentThread().getName() + " number is " + test.number);
        } ,"thread - 2 ").start();

        while(test.number == 0) {

        }
        System.out.println(" main thread number is " + test.number);
    }
}
