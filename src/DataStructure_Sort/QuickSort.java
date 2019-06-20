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
        if (start + end == 8) { //当子数列规模降到8时采用插入排序
            System.out.println("insert sort");
            insertSort(data, start, end);
        }
        int index = partition(data, length, start, end);

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
        for (index = start; index <= end; index++) {
            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    swap(data,small ,index );
                }
            }
        }
        small++;
        swap(data,small ,end );
        return small;
    }

    public void swap(int[] data,int a,int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public void insertSort(int[] a,int start,int end) {
        if (a.length > 1) {
            int j = 0;
            for (int i = start+1; i <=end; i++) {
                int num = a[i];
                for (j = i; j > 0 && a[j - 1] > num; j--) {
                    a[j] = a[j - 1];
                }
                a[j] = num;
            }
        }
    }

    public void shuffle(int[] data,int start,int end) {
        if(start < end) {
            for (int i = 0; i <= end ; i++) {
                int r = (int)Math.random()*(end-i);
                swap(data,r ,i );
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {5,4,3,2,7,8,4,1,5,4,3,2,7,8,4,1,5,4,3,2,7,8,4,1,5,4,3,2,7,8,4,1,5,4,3,2,7,8,4,1,5,4,3,2,7,8,4,1,5,4,3,2,7,8,4,1,5,4,3,2,7,8,4,1};
        QuickSort sort = new QuickSort();
        sort.quickSort(data, data.length, 0, data.length-1);
        for (int i = 0; i < data.length; i++) {
            System.out.print( data[i]+" ");
        }
    }

}
