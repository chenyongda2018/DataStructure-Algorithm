package DataStructure_Sort;

import java.util.Collections;

public class QuickSort {

    public void quickSort(int[] data, int length, int start, int end) {
        if (data == null || length <= 0 || start < 0 || end >= length) {
            return ;
        }
        if ( start == end) {
            return;
        }
        int index = partition(data, length, start, end);
        if (index > start) {
            quickSort(data, length, start, index-1);
        }
        if (index < end ){
            quickSort(data, length, index+1,end );
        }
    }
    public int partition(int[] data, int length, int start, int end) {
        if (data == null || length <= 0 || start < 0 || end >= length) {
            return -1;
        }
        int index = 0;
        int small = start - 1;
        for (index = start; index <= end; index++) {

            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    swap(data[index], data[small]);
                }
            }
        }
        small++;
        swap(data[small], data[end]);
        return small;
    }

    public void swap(int a, int b) {
        int sum = a +b ;
        a = sum - a;
        b =  sum - a;
    }


    public static void main(String[] args) {
//        int[] data = {2,3,4,5,6,2,12,5,6};
        QuickSort sort = new QuickSort();
//        sort.quickSort(data, data.length, 0, data.length-1);
//        for (int i = 0; i < data.length; i++) {
//            System.out.print( data[i]+" ");
//        }
//        int a =1;
//        int b = 2;
//        sort.swap(a, b);
        String str = "hello";
        sort.foo(str);
        System.out.println(str);

    }

    void foo(String str) {
        str = "123";
    }

}
