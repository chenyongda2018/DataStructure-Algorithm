package DataStructure_Sort;

import java.util.Collections;

public class QuickSort {

    public void quickSort(int[] data, int length, int start, int end) {
        if (data == null || length <= 0 || start < 0 || end >= length) {
            return;
        }
        if (start == end) {
            return;
        }
        int index = partition(data, length, start, end);
        quickSort(data, length, start, index - 1);
        quickSort(data, length, index + 1, end);
        if (index > start) {
            quickSort(data, length, start, index - 1);
        }
        if (index < end) {
            quickSort(data, length, index + 1, end);
        }
    }

    public int partition(int[] data, int length, int start, int end) {
        if (data == null || length <= 0 || start < 0 || end >= length) {
            return -1;
        }
        int index = 0;
        int small = start - 1;
        int temp = 0;
        for (index = start; index <= end; index++) {

            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    temp = data[index];
                    data[index] = data[small];
                    data[small] = temp;
                }
            }
        }
        small++;
        temp = data[small];
        data[small] = data[end];
        data[end] = temp;
        return small;
    }

    public static void main(String[] args) {
        int[] data = {5,4,3,2,7,8,4,1};
        QuickSort sort = new QuickSort();
        sort.quickSort(data, data.length, 0, data.length-1);
        for (int i = 0; i < data.length; i++) {
            System.out.print( data[i]+" ");
        }
    }

}
