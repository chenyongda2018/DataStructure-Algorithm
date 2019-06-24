package DataStructure_Sort;


public class HeapSort {
    //1-递归调整节点与它的左节点和右节点
    public void adjustMaxHeap(int[] data, int root, int end) {
        if (data == null || root < 0 || end > data.length - 1) {
            return;
        }
        int left, right, larger;
        left = 2 * root;
        if (left > end) {
            return;
        }
        right = left + 1;
        larger = left;

        if (right <= end && data[left] < data[right]) {
            larger = right;
        }
        if (data[root] < data[larger]) {
            ArrUtil.swap(data, root, larger);
            adjustMaxHeap(data, larger, end);
        }
    }

    //2-构造最大堆
    public void buildMaxHeap(int[] data, int end) {
        for (int i = end / 2; i >= 1; i--) {
            adjustMaxHeap(data, i, end);
        }
    }

    public void maxHeapSort(int[] data, int end) {
        buildMaxHeap(data, end);
        for (int i = end; i >= 1; i--) {
            ArrUtil.swap(data, 1, i);
            adjustMaxHeap(data, 1, end - 1);
        }
    }


    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] data = new int[]{0, 3, 2, 4, 5, 6, 7, 9, 2};
        sort.maxHeapSort(data, data.length -1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

}
