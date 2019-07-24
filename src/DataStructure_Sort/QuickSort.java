package DataStructure_Sort;

import java.util.Collections;

public class QuickSort {

    public static void quickSort(int[] arr) {
        if(arr == null) return ;
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int arr[],int start,int end) {
        if(start >= end) return;
        int index = partition(arr,start,end);
        sort(arr,start,index - 1);
        sort(arr,index+1,end);
    }



    public static int partition(int[] arr,int start,int end){
        int i = start;
        int j = end;
        int num = arr[start];

        while(true) {
            while(arr[i++] <= num) if(i == end) break;
            while(arr[j--] >= num) if(j == start) break;
            if( i >= j) break;
            exch(arr,i,j);
        }
        exch(arr,i,start);
        return j;
    }

    public static void exch(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
