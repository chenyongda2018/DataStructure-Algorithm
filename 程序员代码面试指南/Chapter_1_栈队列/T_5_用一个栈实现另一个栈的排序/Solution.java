package Chapter_1_栈队列.T_5_用一个栈实现另一个栈的排序;

import java.util.Stack;

public class Solution {


    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();

            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 5; i >=0; i--) {
            stack.push(i);
        }
        sortStackByStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
