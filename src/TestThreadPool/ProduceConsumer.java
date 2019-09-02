package TestThreadPool;

public class ProduceConsumer {
    Object lock = new Object();

    int num = 0;

    //加1
    void increament() {
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
