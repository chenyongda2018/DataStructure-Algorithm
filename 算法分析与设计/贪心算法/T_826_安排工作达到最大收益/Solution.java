package 贪心算法.T_826_安排工作达到最大收益;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 有一些工作：difficulty[i] 表示第i个工作的难度，profit[i]表示第i个工作的收益。
 * <p>
 * 现在我们有一些工人。worker[i]是第i个工人的能力，即该工人只能完成难度小于等于worker[i]的工作。
 * <p>
 * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 * <p>
 * 举个例子，如果3个工人都尝试完成一份报酬为1的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 * <p>
 * 我们能得到的最大收益是多少？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-profit-assigning-work
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (difficulty == null || profit == null || worker == null) return 0;
        int[][] job = new int[difficulty.length][];
        for (int i = 0; i < job.length; i++) {
            job[i][0] = difficulty[i];
            job[i][1] = profit[i];
        }

        //将工作按报酬从低到高排列
        Arrays.sort(job, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if (ints[1] > t1[1]) {
                    return 1;
                } else if (ints[1] < t1[1]) {
                    return -1;
                }
                return 0;
            }
        });

        Arrays.sort(worker);

        int profits = 0;
        int lastWorkSelect = 0;
        int selectProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            for (int j = lastWorkSelect; j < job.length; j++) {
                if (job[j][0] <= worker[i]) {
                    lastWorkSelect = j;
                    selectProfit = job[j][1];
                }
            }
            profits += selectProfit;
        }

        return profits;
    }

    /**
     * 动态规划
     */
    public int maxProfitAssignment_2(int[] difficulty, int[] profit, int[] worker) {
        if (difficulty == null || profit == null || worker == null) return 0;

        int maxDifficcut = 10000;
        int max_profit[] = new int[maxDifficcut+1];

        for (int i = 0; i < difficulty.length; i++) {
            max_profit[difficulty[i]] = profit[i];
        }

        int best = 0;
        int sum = 0;
        for (int i = 1; i < max_profit.length; i++) {
            best = Math.max(max_profit[i-1],max_profit[i] );
            max_profit[i] = best;
        }
        for (int i = 0; i < worker.length; i++) {
            sum += max_profit[i];
        }

        return sum;

    }
}
