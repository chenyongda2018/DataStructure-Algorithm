package TestList;

public class TestDeamon {



    public static void main(String[] args) throws InterruptedException {

        DaemonT thread = new DaemonT();
        thread.setDaemon(true);
        thread.start();
        thread.join();
        System.out.println(thread.getPriority());
        System.out.println();
    }



    static class DaemonT extends Thread {
        @Override
        public void run() {

            try {
                System.out.println("this si daemon");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println("finally is run.");
            }
        }
    }
}
