package T_13_机器人的运动范围;

/**
 * 思路 :
 * 回溯法:
 * 从第一个格子开始，检验机器人是否能够进入，如果能进入此格子
 * 再继续进入它上下左右四个格子，
 */
public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        int count = countMatrix(threshold, rows, cols, 0, 0, visited);
        return count;

    }


    public int countMatrix(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + countMatrix(threshold, rows, cols, row + 1, col, visited)
                    + countMatrix(threshold, rows, cols, row - 1, col, visited)
                    + countMatrix(threshold, rows, cols, row, col + 1, visited)
                    + countMatrix(threshold, rows, cols, row, col - 1, visited);
        }

        return count;
    }

    /**
     * 对每一步进行检验
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */

    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row < rows && row >= 0
                && col < cols && col >= 0
                && !visited[row * cols + col]
                && getNumSun(row) + getNumSun(col) <= threshold
                ) {
            return true;
        }
        return false;
    }


    /**
     * 得到一个多位数的各位数字相加之和
     *
     * @param num
     * @return
     */
    public int getNumSun(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.movingCount(5, 10, 10));
    }
}
