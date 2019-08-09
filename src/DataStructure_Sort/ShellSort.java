package DataStructure_Sort;

import java.util.Arrays;

public class ShellSort {

    public static void shellSort(int[] data) {
        int length = data.length;
        for (int gab = length/2;gab>0;gab/=2) {
            for (int i = gab; i < length; i++) {
                int j = i;
                while(j-gab>=0&&data[j] < data[j-gab]) {
                    ArrUtil.swap(data,j,j-gab);
                    j-=gab;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{3,2,1,4,5,7};
        shellSort(data);
        System.out.println(Arrays.toString(data));
    }


}
