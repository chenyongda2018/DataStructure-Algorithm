package 数组形式的整数加法_989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {

        int k = K;
        int i = A.length;
        List<Integer> list = new ArrayList<>();
        while (--i >= 0 || k > 0) {
            if (i >= 0) {
                k += A[i];
            }
            list.add(k % 10); //取最后一位
            k = k / 10; //去掉最后一位
        }
        Collections.reverse(list);
        return list;

    }
}
