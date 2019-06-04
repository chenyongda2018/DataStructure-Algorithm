package T_30_包含min函数的栈;

import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Solution {
    private Stack<Integer> data_stack = new Stack<>();
    private Stack<Integer> min_stack = new Stack<>();

    public void push(int node) {
        if(min_stack.size() == 0 || node < min_stack.peek()) {
            data_stack.push(node);
            min_stack.push(node);
        } else {
            data_stack.push(node);
            min_stack.push(min_stack.peek());
        }
    }

    public void pop() {
        if (data_stack .size() == 0 || min_stack.size() == 0 ) {
            return;
        }

        data_stack.pop();
        min_stack.pop();

    }

    public int top() {
        if (data_stack .size() == 0 ) {
            return 0;
        }
        return data_stack.peek();
    }

    public int min() {
        if (min_stack.size() == 0) {
            return 0;
        }
        return min_stack.peek();
    }
}
