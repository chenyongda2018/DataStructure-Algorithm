package 贪心算法.T_1029_两地调度;
import java.util.*;
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        if (costs==null || costs.length < 1) return 0;

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                int num1 = ints[0] - ints[1];
                int num2 = t1[0] - t1[1];
                //按差值从大到小排序
                if (num1 <  num2) {
                    return 1;
                } else if (num1 > num2) {
                    return -1;
                }
                return 0;
            }
        });
        int sum = 0;
        int middle = costs.length/2;
        for(int i = 0;i <= middle-1;i++)
        {
            sum+=costs[i][1];
        }

        for (int i = middle;i<costs.length;i++) {
            sum+=costs[i][0];
        }


        return sum;


    }
}
