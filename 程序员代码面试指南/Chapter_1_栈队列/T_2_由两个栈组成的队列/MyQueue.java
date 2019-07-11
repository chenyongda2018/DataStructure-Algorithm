package Chapter_1_栈队列.T_2_由两个栈组成的队列;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stackData;
    private Stack<Integer> stackPop;


    public MyQueue() {
        stackData = new Stack<>();
        stackPop = new Stack<>();
    }

    /**
     * 将数据栈的数据倾倒给顺序栈
     */
    public void pushToPop() {
        if (stackPop.empty()) {
            while (!stackData.isEmpty()) {
                stackPop.push(stackData.pop());
            }
        }
    }

    public void add(int num) {
        stackData.push(num);
        pushToPop();
    }


    public int poll() {
        if (stackData.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.pop();
    }


    public int peek() {
        if (stackData.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.peek();
    }

}
