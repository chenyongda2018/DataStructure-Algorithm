package DataStructure_Sort;

public class InsertSort {

    public int[] insertSort(int[] a) {
        if (a.length > 1) {
            int j = 0;
            for (int i = 1; i < a.length; i++) {
                int num = a[i];
                for (j = i; j > 0 && a[j - 1] > num; j--) {
                    a[j] = a[j - 1];
                }
                a[j] = num;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] a = new int[]{1, 2, 3, 35, 23, 67, 34, 89, 12, 34};
        int[] sort_a = insertSort.insertSort(a);

        for (int num : sort_a) {
            System.out.println(num + " ");
        }
    }
}
