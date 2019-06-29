package T_59_1_滑动窗口的最大值;

/**
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> results = new ArrayList<>();
        if(num == null || num.length < size) return results;


        PriorityQueue<Integer> maxTree = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer integer,Integer t1) {
                if (t1 > integer) return 1;
                if (t1 < integer) return -1;
                return 0;
            }
        });
        for(int i = 0;i<= num.length-size;i++) {
            int end = i+size-1;
            for (int j = i;j <=end;j++) {
                maxTree.offer(num[j]);
            }
            if (maxTree.peek() != null)
                results.add(maxTree.poll());
            maxTree.clear();
        }

        return results;
    }
}
