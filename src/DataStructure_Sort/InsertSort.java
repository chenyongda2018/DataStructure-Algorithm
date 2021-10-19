package DataStructure_Sort;

public class InsertSort {


    public static int[] insertSort(int[] a, int start, int end) {
        if (a.length > 1) {
            int j = 0;
            for (int i = start + 1; i <= end; i++) {
                int num = a[i]; //已排序序列
                for (j = i; j > 0 && a[j - 1] > num; j--) {
                    a[j] = a[j - 1];
                }
                a[j] = num;
            }
        }
        return a;
    }

    public static int[] sort(int[] arr) {
        if (arr == null) return null;
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            int j = 0;
            for(j = i ; j >= 0 && arr[j- 1] > arr[j];j--) {
                ArrUtil.swap(arr,j-1,j);
            }
        }
        return arr;
    }

//    public static int[] sort(int[] arr) {
//        if (arr == null) return null;
//        int N = arr.length;
//        for (int i = 1; i < N; i++) {
//            int j = 0;
//            for(j = i ; j >= 0 && arr[j- 1] > arr[j];j--) {
//                ArrUtil.swap(arr,j-1,j);
//            }
//        }
//        return arr;
//    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] a = new int[]{1, 2, 3, 35, 23, 67, 34, 89, 12, 34};
        int[] sort_a = sort(a);
//        int[] sort_a = insertSort(a,0, a.length-1);

        for (int num : sort_a) {
            System.out.println(num + " ");
        }
    }
}
