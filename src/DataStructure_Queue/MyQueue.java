package DataStructure_Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通队列实现
 */

public class MyQueue {
    private List<Integer> dataQueue;//动态数组
    private int p_head;


    public MyQueue() {
        dataQueue = new ArrayList<>();
        p_head = 0;
    }

    public boolean isEmpty() {
        return dataQueue.isEmpty();
    }

    /**
     * 入队
     */
    public boolean enQueue(int x) {
        dataQueue.add(x);
        return true;
    }

    /**
     * 出队
     * v1.0: 通过增加head索引 简单的表示此队列的第一个元素 “出队”。
     * 缺点: 实际元素还存在于队列中，并且占用空间。
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        p_head++;
        return true;
    }

    /**
     * 获得队列第一个元素
     * @return
     */
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return dataQueue.get(p_head);
    }
}
