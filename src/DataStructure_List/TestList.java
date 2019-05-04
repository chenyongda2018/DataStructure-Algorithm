package DataStructure_List;

import java.util.Iterator;

public class TestList {
    public static void main(String[] args) {
        testLinkList();
    }

    public static void testArrayList() {
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

    public static void testLinkList() {
        MyLinkList linkList = new MyLinkList();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        linkList.add(5);
        Iterator iterator = linkList.iterator();
        while (iterator.hasNext()) {
            int num = (Integer) iterator.next();
            System.out.print(num+" ");
        }

    }
}
