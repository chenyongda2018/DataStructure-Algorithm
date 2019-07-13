package Chapter_1_栈队列.T_8_单调栈结构;

import java.util.Stack;

/**
 * 建立一个栈：保持栈顶到栈底递减的顺序(单调栈结构)
 * 栈中存放坐标
 * 对arr进行遍历，当栈顶元素代表的值 大于 当前遍历的值 ，则弹出。 小于或者栈为空时放入当前遍历的位置。
 * 弹出时的位置时pop,此时栈顶的元素代表的值必定小于pop的值且最近，而且当前遍历的值大于pop且最近。
 */
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
