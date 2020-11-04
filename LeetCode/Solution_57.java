import java.util.ArrayList;
import java.util.List;

/**
 * 将S与区间逐一比对，当遇到重叠时，融合产生新的S
 * 当遇到大于S且不与S重叠的区间时，结束比较，插入S
 */
public class Solution_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];

        List<int[]> list = new ArrayList<>();
        boolean insert = false;
        for (int[] ints : intervals) {
            if (ints[0] > right) {
                if (!insert) {
                    list.add(new int[]{left, right});
                    insert = true;
                }
                list.add(ints);
            } else if (ints[1] < left) {
                list.add(ints);
            } else {
                left = Math.min(left, ints[0]);
                right = Math.max(right, ints[1]);
            }
        }

        if (!insert) {
            list.add(new int[]{left, right});
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
