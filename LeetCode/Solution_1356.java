import java.util.Arrays;
import java.util.Comparator;

public class Solution_1356 {
    public int[] sortByBits(int[] arr) {
        Integer[] list = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            list[i] = arr[i];
        }

        Arrays.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int i = get1Count(o1);
                int j = get1Count(o2);
                if (i == j) {
                    return o1 - o2;
                }
                return i - j;
            }
        });

        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = list[i];

        }
        return res;
    }


    public int get1Count(int i) {
        int cnt = 0;
        while (i != 0) {
            i = (i & (i - 1));
            cnt++;
        }
        return cnt;
    }
}
