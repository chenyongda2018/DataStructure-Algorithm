package 动态规划.T_2_子集之和等于指定值;

/**
 * 给出一个数组，和target值，判断数组中是否有子集的和等于target
 */
public class Solution {


    public boolean rec_opt(int[] data, int i, int target) {
        if (data == null || data.length < 1) {
            return false;
        }

        if (target == 0) {
            return true;
        }

        if (i == 0) {
            return data[i] == target;
        }

        if (data[i] > target) {
            return rec_opt(data, i - 1, target);
        }

        boolean select = rec_opt(data, i - 1, target - data[i]);
        boolean noSelect = rec_opt(data, i - 1, target);
        return select || noSelect;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] data = new int[]{3, 34, 4, 12, 5, 2};
        int target = 100;

        System.out.println(s.rec_opt(data, data.length - 1, target)); //false
    }
}
