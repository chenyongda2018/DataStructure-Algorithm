package DataStructure_Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Vector;

public class QuickSort {


    public static void main(String[] args) {
//        int[] data = new int[]{9,8,7,6,5,4,3,2,1};
//        int[] data = new int[]{6, 7, 4, 6, 3, 2, 1, 8, 0, 2};
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1,9,9};
        quickSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void quickSort(int[] arr) {
        if (arr == null) return;
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int arr[], int start, int end) {
        if (start >= end) return;
        int index = partition(arr, start, end);
        sort(arr, start, index - 1);
        sort(arr, index + 1, end);
    }


    public static int partition(int[] arr, int start, int end) {
        int i = start;
        int j = end + 1;
        int num = arr[start];
        while (true) {
            while (arr[++i] < num) if (i == end) break;
            while (arr[--j] > num) if (j == start) break;
            if (i >= j) break;
            exch(arr, i, j);
        }
        exch(arr, start, j);

        return j;
    }

    public static void exch(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
