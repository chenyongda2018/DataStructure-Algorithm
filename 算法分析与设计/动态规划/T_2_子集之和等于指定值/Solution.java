package 动态规划.T_2_子集之和等于指定值;

/**
 * 给出一个数组，和target值，判断数组中是否有子集的和等于target
 */
public class Solution {


    /**
     * 递归实现
     * @param data
     * @param i
     * @param target
     * @return
     */
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


    /**
     * 动态规划，填表法
     * @param data
     * @param target
     * @return
     */
    public boolean noRec_opt(int[] data,int target) {
        if (data == null || data.length < 1) {
            return false;
        }
        boolean[][] opt = new boolean[data.length][target+1];
        for (int i = 1; i < data.length; i++) {
            opt[i][0] = true;
        }

        for (int i = 0; i < target; i++) {
            opt[0][i] = false;
            if (i == data[0]) {
                opt[0][i] = true;
            }
        }

        for (int i = 1 ; i < data.length ; i++) {
            for (int j = 1; j < target+1; j++) {
                if (data[i] > j) {
                    opt[i][j] = opt[i-1][j];
                }else {
                    boolean select = opt[i-1][j - data[i]];
                    boolean noSelect = opt[i-1][j];
                    opt[i][j] = select || noSelect;
                }
            }
        }

        return opt[data.length-1][target];

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] data = new int[]{3, 34, 4, 12, 5, 2};
        int target = 7;

        System.out.println(s.noRec_opt(data, target)); //false
    }
}
