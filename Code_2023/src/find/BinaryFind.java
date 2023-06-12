package find;

public class BinaryFind {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
//        int index = binarySearch(arr, 6);
//        System.out.println(index);

        int[] arr = new int[]{1, 2, 6, 6, 6, 6, 7, 8};
        int index = binarySearch1(arr, 0);
        System.out.println(index);
    }

    /**
     * 查找一个值
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length < 1) return -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找一个值的左侧边界
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch1(int[] arr, int target) {
        if (arr == null || arr.length < 1) return -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                high = mid - 1;
            }
        }

        if (low > arr.length - 1 || arr[low] != target) return -1;
        return low;
    }
}
