package Chapter_1_栈队列.T_8_单调栈结构;

import java.util.Stack;

public class Solution {

    public static int[][] getNearestMinMaxIndex(int[] arr) {

        if (arr == null) return null;

        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int pop = stack.pop();
                int leftMinIdx = stack.isEmpty() ? -1 : stack.peek();
                res[pop][0] = leftMinIdx;
                res[pop][1] = i;

            }
            stack.push(i);
        }

        while (!stack.empty()) {
            int pop = stack.pop();
            int leftMinIdx = stack.empty() ? -1 : stack.peek();
            res[pop][0] = leftMinIdx;
            res[pop][1] = -1;
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 5, 6, 2, 7};
        int[][] res = getNearestMinMaxIndex(arr);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
}
