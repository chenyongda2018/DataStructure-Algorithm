package DataStructure_Queue;

import java.util.ArrayList;
import java.util.List;

public class CircularQueue {
    private int[] dataQueue;//动态数组
    private int p_head; //头指针
    private int p_tail; //尾指针
    private int size; //数组大小


    public CircularQueue(int k) {
        size = k;
        dataQueue = new int[k];
        p_head = -1;
        p_tail = -1;
    }

    public boolean isEmpty() {
        return p_head == -1;
    }

    /**
     * 入队
     * 若数组为空，则第一次添加元素时,head由-1指向0
     *
     */
    public boolean enQueue(int x) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            p_head = 0;
        }
        /**
         * p_tail = (p_tail + 1) % size 表示 :
         * 每当进来一个元素，尾指针就跟着+1，对size取余能够保证在循环队列中尾指针始终指向最后添加的元素的位置
         */
        p_tail = (p_tail + 1) % size;
        dataQueue[p_tail] = x;
        return true;
    }

    /**
     * 出队
     *
     *
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        //数组为空时
        if (p_head == p_tail) {
            p_head = -1;
            p_tail = -1;
            return true;
        }
        /**
         * p_head = (p_head + 1) % size; 表示 :
         * 每当进来一个元素，头指针指针就跟着+1，对size取余能够保证在循环队列中头指针指针始终指向最先添加的元素的位置
         */
        p_head = (p_head + 1) % size;
        return true;
    }

    /**
     * 获得目前队列第一个元素
     *
     * @return
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return dataQueue[p_head];
    }

    /**
     * 获得目前队列最后一个元素
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return dataQueue[p_tail];
    }

    /**
     * 当数组满时 tail+1就会跟head重合
     *
     * @return
     */
    public boolean isFull() {
        return (p_tail + 1) % size == p_head;
    }
}
