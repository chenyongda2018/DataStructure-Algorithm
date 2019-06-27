package 贪心算法.T_1046_最后一块石头的重量;

import java.util.*;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length < 1) return 0;

        Arrays.sort(stones);

        int max1 = stones.length - 1;
        int max2 = stones.length - 2;
        Arrays.sort(stones);

        while (max2 >= 0 && stones[max2] != 0) {
            int diff = stones[max1] - stones[max2];
            if (diff == 0) {
                stones[max1] = 0;
                stones[max2] = 0;
            } else {
                stones[max1] = 0;
                stones[max2] = diff;
            }
            Arrays.sort(stones);
        }
        return stones[max1];
    }

    //运用大顶堆
    public int lastStoneWeight2(int[] stones) {
        if (stones == null || stones.length < 1) return 0;
        PriorityQueue<Integer> maxTree = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if (t1 > integer) {
                    return 1;
                } else if(t1 < integer) {
                    return -1;
                }
                return 0;
            }
        });

        //构造最大堆，堆顶是最大元素
        for (int i = 0; i < stones.length; i++) {
            maxTree.offer(stones[i]);
        }

        while (maxTree.size() > 1) {
            int max1 = maxTree.poll();
            int max2 = maxTree.poll();
            int diff = max1 - max2;
            if (diff != 0) {
                maxTree.offer(diff);
            }
        }

        if (maxTree.isEmpty()) {
            return 0;
        }
        return maxTree.poll();



    }
}
