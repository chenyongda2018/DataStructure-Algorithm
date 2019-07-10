package Chapter_1_栈队列.T_1_设计一个又getMin功能的栈;


import java.util.Stack;

/**
 * 题目:实现一个具有getMin功能的栈
 * 实现:内部维护一个数据栈，一个存放每一步插入之后最小值的栈
 * 插入时:
 * 数据栈:直接插入。
 * 最小值栈:为空时，直接插入。不为空时，与栈顶元素比较，小于等于则放入
 *
 * 弹出时:
 * 数据栈:直接弹出value
 * 最小值栈:不为空时,如value小于等于栈顶元素则弹出
 */
public class MyStack {
    private Stack<Integer> stackData ;
    private Stack<Integer> stackMin;

    public MyStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    /**
     * 插入操作
     * @param newNum
     */
    public void push(int newNum) {
        if (stackMin.isEmpty() || newNum <= stackMin.peek()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Stack in empty!");
        }
        return stackMin.peek();
    }

    public int size() {
        return stackData.size();
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Stack in empty!");
        }
        int value = stackData.pop();
        if (value <= stackMin.peek()) {
            stackMin.pop();
        }
        return value;
    }
}
