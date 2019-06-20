package T_41_数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
 */
public class Solution {
    //最小堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //最大堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int count = 0;
    public void Insert(Integer num) {
        count ++;
        if ((count & 1) == 1) {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        } else {
            if (!maxHeap.isEmpty()&& num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
    }



    public Double GetMedian() {
        int size = minHeap.size() + maxHeap.size();
        double result = 0;
        if ((size & 1) == 0) {
            result = (minHeap.peek()+maxHeap.peek())/2.0;
        } else {
            result = maxHeap.peek();
        }
        return result;
    }

}
