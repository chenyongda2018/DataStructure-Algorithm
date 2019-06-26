package 贪心算法.T_452_用最少量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;
/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 *
 */

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
 *
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
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
        int right = points[0][1];
        int arr = 1;//所需弓箭的数量
        for(int i = 1; i< points.length;i++) {
            if (points[i][0] > right) {
                arr++;
                right = points[i][1];
            }
        }

        return arr;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] data = new int[][]  {{10,16},{2,8},{1,6},{7,12}};
        s.findMinArrowShots(data);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(data[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
