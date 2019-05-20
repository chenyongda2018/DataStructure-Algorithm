package T9_用两个栈实现队列;

import java.util.Stack;

/**
 * 用两个栈实现队列的弹出对头( pop() )和队尾插入( push(int node) )操作
 * 1.当push一个元素时，放入stack1中。
 * 2.当pop一个元素时，如果stack2为空,则将stack1中的元素挨个的弹出并放入stack2中。这样最先进来的元素会出现在stack2的栈顶,
 * 3.再弹出stack2的栈顶元素
 * 4.如果stack2不为空,直接弹出stack2的栈顶元素
 *
 *
 */
public class StackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        for (int i = 1; i < 4; i++) {
            queue.push(i);
        }
        int num = queue.pop();
        System.out.println(num);
    }


}
