package DataStructure_Sort;

public class SelectSort {


    public void selectSort1(int[] data) {
        int length = data.length;
        for (int i = 0; i < length-1; i++) {
            int min  = i;
            for (int j = i+1; j < length-1; j++) {
                if(data[j] <= data[min]) {
                    min = j;
                }
            }
            swap(data,i,min);
        }
    }


    //递归实现选择排序
    public void selectSort(int[] data, int start, int end) {
        if (data == null || start < 0 || end > data.length - 1) {
            return;
        }
        if (start == end) {
            return;
        }
        int index = start;
        //找出最小数的位置
        for (int i = start; i <= end; i++) {
            if (data[index] > data[i]) {
                index = i;
            }
        }
        if (index != start) {
            swap(data,start,index);
        }

        selectSort(data,start+1,end);

    }

    public void swap(int[] data, int from, int to) {
        int temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }


    public static void main(String[] args) {
        SelectSort sort = new SelectSort();
        int[] data = new int[]{5,4,3,7,8,5,2,2,6,8,9};
//        sort.selectSort(data,0,data.length-1);
        sort.selectSort1(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
    }
}
