package TestList;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {
    private static ArrayList<Integer> list = new ArrayList<>();

    static class Thread1 extends Thread {
        @Override
        public void run() {
            Iterator<Integer> iterator = list.iterator();
            int i = 0;
            while(iterator.hasNext()) {

                if(i == 3) list.remove(3);
                i++;
            }
        }
    }

    static class Thread3 extends Thread {
        @Override
        public void run() {
            Iterator<Integer> iterator = list.iterator();
            int i = 0;
            while(iterator.hasNext()) {

                if(i == 4) list.remove(4);
                i++;
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        new Thread1().start();
        new Thread2().start();

    }


}
