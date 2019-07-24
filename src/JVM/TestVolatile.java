package JVM;

public class TestVolatile {

    private static final int THREAD_COUNT = 20;
    private static volatile int num = 0;

    public static void increase() {
        num++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    increase();
                }
            });
            threads[i].start();
        }

        while(Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(num);
    }
}
