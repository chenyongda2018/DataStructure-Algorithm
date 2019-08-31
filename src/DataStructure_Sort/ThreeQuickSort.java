package DataStructure_Sort;

import java.util.Arrays;

/**
 * 优化之后的快速排序-三向切分
 */
public class ThreeQuickSort {


    public static void main(String[] args) {

        int[] data = new int[]{2,7,9,4,3,6,0};
        threeQuickSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }

    /**
     * a[start..lt-1]中的元素都小于pivot
     * a[lt...i-1]中的元素都等于pivot
     * a[gt+1...end]中的元素都大于pivot
     * @param arr
     * @param start
     * @param end
     */
    public static void threeQuickSort(int[] arr,int start,int end) {
        if (start >= end || arr == null) return;
        int lt = start;
        int i = lt+1;
        int gt = end;
        int num = arr[start];
        while( i <= gt) {
            if(num < arr[i]) exch(arr,i,gt--);
            if(num > arr[i]) exch(arr,i++,lt++);
            if(num == arr[i]) i++;
        }
        threeQuickSort(arr,start,lt-1);
        threeQuickSort(arr,gt+1,end);
    }

    public static void exch(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
