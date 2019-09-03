package DataStructure_Sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {

    public void countSort(int[] arr) {
        if (arr == null) return;
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        int[] data = new int[max - min + 1];
        int offset = 0 - min;
        for (int i = 0; i < arr.length; i++) {
            data[arr[i] + offset]++;
        }

        System.out.println(Arrays.toString(data));
        System.out.println(max);
        System.out.println(min);
        int i = 0,count = 0;
        while (i < arr.length) {

            if (data[count] != 0) {
                arr[i] = count - offset;
                data[count]--;
                i++;
            } else {
                count ++;
            }
        }


        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 1, 5, 8, 0, 2, 5};
        new CountingSort().countSort(arr);
    }
}
