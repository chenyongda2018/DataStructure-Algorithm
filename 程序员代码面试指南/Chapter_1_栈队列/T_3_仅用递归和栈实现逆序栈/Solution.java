package Chapter_1_栈队列.T_3_仅用递归和栈实现逆序栈;

import java.util.Stack;

public class Solution {

    /**
     * 移除并返回栈底元素
     */
    public static int getAndRemoveLast(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.empty()) { //如果栈为空，说明 result是栈底元素 返回
            return result;
        } else { //栈不为空时，继续递归调用
            int last = getAndRemoveLast(stack);
            stack.push(result);
            return last;
        }

    }


    /**
     *依次取出栈底元素，第一个栈底元素最后进入栈，最后一个栈底元素先入栈，实现逆序
     */

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int i = getAndRemoveLast(stack);
        reverseStack(stack);
        stack.push(i);
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }// 4,3,2,1,0
        reverseStack(stack); //0,1,2,3,4

        while(!stack.empty()) {
            System.out.println(stack.pop());
        }

    }
}
