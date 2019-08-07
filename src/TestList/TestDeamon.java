package TestList;

public class TestDeamon {



    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.setDaemon(true);
        System.out.println(thread.isDaemon());
    }
}
