package DataStructure_Sort;


import java.util.Arrays;

public class HeapSort {

    /**
     * heap sort method
     *
     * @param arr
     * @param length
     */
    public static void heapSort(int arr[], int length) {
        if (arr == null) return;
        build_heap(arr,length);
        for (int i = length; i >=0 ; i--) {
            ArrUtil.swap(arr,0,i);
            build_heap(arr,i);
        }
    }

    /**
     * 从 最后一个结点的父节点开始，往前一个一个的执行heapify
     * @param arr
     * @param length
     */
    public static void build_heap(int arr[], int length) {
        int last = length;
        int parent = (last - 1) / 2;

        for (int i = parent; i >= 0; i--) {
            heapfy(arr, length, i);
        }
    }

    /**
     * 调整父节点与2个字节点的顺序。
     *
     * @param arr
     * @param length
     */
    public static void heapfy(int arr[], int length, int n) {
        if (n > length) return;
        int c1 = 2 * n + 1;
        int c2 = 2 * n + 2;
        int max = n;
        if (c1 < length && arr[c1] > arr[max]) max = c1;
        if (c2 < length && arr[c2] > arr[max]) max = c2;

        if (max != n) {
            ArrUtil.swap(arr, n, max);
            heapfy(arr, length, max);
        }


    }


    public static void main(String[] args) {
        int[] data = new int[]{0, 3, 2, 4, 5, 6, 7, 9, 2};
        heapSort(data,data.length-1);

        System.out.println(Arrays.toString(data));
    }

}
