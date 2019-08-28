package DataStructure_Sort;


/**
 * 折半查找
 *
 * @author cyd
 * @date 2019/7/15 16:36
 */
public class BinarySearch {

    public static int binarySearch(int[] a, int key) {
        if (a == null) return -1;
        int low = 0, mid = 0;
        int high = a.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,3,45,5,6,21,5};
        System.out.println(binarySearch(arr,5));
    }



}
