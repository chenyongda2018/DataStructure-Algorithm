import java.util.ArrayList;
import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public int[] radixSort(int[] arr) {
        if (arr == null) return null;
        ArrayList<Integer>[] data = new ArrayList[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = new ArrayList<>();
        }

        int max = arr[0]; //最大数

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }

        int maxdigit = 0;//记录最大数有多少位

        while (max != 0) {
            max /= 10;
            maxdigit++;
        }

        int mod = 10, divide = 1;
        for (int i = 0; i < maxdigit; i++, mod *= 10, divide *= 10) {
            //所在位是1的放到第1个桶
            //所在位是n的放到第n个桶
            for (int j = 0; j < arr.length; j++) {
                //记录每一位数值, 例 : 123 % 10 /1 = 3 (123的个位数字)
                int singleNum = arr[j] % mod / divide;
                data[singleNum].add(arr[j]);
            }

            int index = 0 ;
            //将桶中的数字,按照从0-9顺序再放回数组中
            for (int j = 0; j < data.length; j++) {
                for (int k = 0; k < data[j].size(); k++) {
                    arr[index++] = data[j].get(k);
                }
                data[j].clear();
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{100,727,920,20,6,72,499};
        new RadixSort().radixSort(arr);
    }

}
