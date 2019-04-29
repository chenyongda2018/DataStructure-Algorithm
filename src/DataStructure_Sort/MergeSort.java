package DataStructure_Sort;

import java.util.logging.Handler;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{3,2,1,45,56,67,6,432,45,2};
        sort(a);
        for (int num : a) {
            System.out.println(num + " ");
        }
    }


    public static void sort(int[] a) {
        int[] temp = new int[a.length];
        mergeSort(a, temp, 0, a.length - 1);
    }

    //归并排序
    public static void mergeSort(int[] a, int[] temp, int leftPos, int rightEnd) {
        if (rightEnd > leftPos) {
            int middle = (rightEnd + leftPos) / 2;
            mergeSort(a, temp, leftPos, middle);
            mergeSort(a, temp, middle + 1, rightEnd);
            merge(a, temp, leftPos, rightEnd, middle);
        }
    }

    //合并两个排过序对的数组
    public static void merge(int[] a, int[] temp, int leftPos, int rightEnd, int middle) {
        int leftEnd = middle ;
        int tempPos = leftPos;
        int rightPos = middle + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] < a[rightPos]) {
                temp[tempPos++] = a[leftPos++];
            } else {
                temp[tempPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            temp[tempPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) {
            temp[tempPos++] = a[rightPos++];
        }

        int numElement = rightEnd - leftPos + 1;


        for (int i = 0; i <= rightEnd; i++) {
            a[i] = temp[i];
        }

    }


}
