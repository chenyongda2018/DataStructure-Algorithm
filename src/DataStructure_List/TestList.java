package DataStructure_List;

import java.util.Iterator;

public class TestList {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("hello");
        list.add("world");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
