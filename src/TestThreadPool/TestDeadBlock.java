package TestThreadPool;

public class TestDeadBlock {
    public static void main(String[] args) {
        String lockA ="lockA";
        String lockB ="lockB";
        new Thread(new MyRunnable(lockA,lockB),"thread 1").start();
        new Thread(new MyRunnable(lockB,lockA),"thread 2").start();
    }
}


class MyRunnable implements Runnable {

    String lockA;
    String lockB;

    public MyRunnable(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()+"正在持有"+lockA+"-尝试获得"+lockB);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"获取到"+lockB);
            }
        }
    }
}