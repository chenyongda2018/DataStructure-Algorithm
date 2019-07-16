package DataStructure_Sort;

import java.util.Arrays;

public class BubbleSort {

    //优化前
    public static void bubbleSort(int[] arr) {
        if (arr ==null) return;
        for (int i = 0;i < arr.length-1;i++) {
            boolean isSwap = false;
            for (int j = 0 ;j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);

                    System.out.println(Arrays.toString(arr));

                }
            }
            System.out.println("#############");
            System.out.println(Arrays.toString(arr));
        }
    }


    public static void bubbleSort2(int[] arr) {
        if (arr ==null) return;
        for (int i = 0;i < arr.length-1;i++) {

            boolean isSwap = false;
            for (int j = 0 ;j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                    isSwap = true;
                    System.out.println(Arrays.toString(arr));
                }
            }
            if (!isSwap) {
                break;
            }
            System.out.println("#############");
            System.out.println(Arrays.toString(arr));
        }
    }


    public static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {6,4,7,9,34,9,2,23,45,6};
        bubbleSort(arr);
    }




}
