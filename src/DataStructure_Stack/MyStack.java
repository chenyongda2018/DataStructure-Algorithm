package DataStructure_Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 栈:先进后出 LIFO
 */
public class MyStack {
    private List<Integer> dataStack;

    public MyStack() {
        dataStack = new ArrayList<>();
    }

    /**
     * 入栈
     *
     * @param x
     */
    public void push(int x) {
        dataStack.add(x);
    }


    /**
     * 获得栈中的最小值
     * @return
     */
    public int getMin() {
        int min = dataStack.get(dataStack.size() - 1);
        for (int i : dataStack) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    /**
     * 出栈 : 删除栈顶的元素
     *
     * @return
     */
    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        dataStack.remove(dataStack.size() - 1);
        return true;
    }

    public boolean isEmpty() {
        return dataStack.isEmpty();
    }

    /**
     * 获得栈顶元素
     * @return
     */
    public int getTop() {
        return dataStack.get(dataStack.size() - 1);
    }


}
