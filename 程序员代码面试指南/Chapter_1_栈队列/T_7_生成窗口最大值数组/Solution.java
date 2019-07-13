package Chapter_1_栈队列.T_7_生成窗口最大值数组;

import java.util.LinkedList;

public class Solution {

    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        /**
         * 用队列存放下标
         */
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);

            if( qmax.peekFirst() == (i-w)) {
                qmax.pollFirst();
            }

            if ( i >= w -1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        int[] res = new Solution().getMaxWindow(arr,3 );
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
