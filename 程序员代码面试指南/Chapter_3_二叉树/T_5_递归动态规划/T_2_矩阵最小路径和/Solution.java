package Chapter_3_二叉树.T_5_递归动态规划.T_2_矩阵最小路径和;

public class Solution {

    /**
     * 动态规划:填表法
     * dp[i][j] 表示为 0，0位置到此位置的最小距离
     * 方法1 ： 空间复杂度O(m*n)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int[][] bp = new int[grid.length][grid[0].length];

        bp[0][0] = grid[0][0];

        //第一列的值等于原矩阵的第一列上依次相加
        for(int row = 1; row < grid.length;row++) {
            bp[row][0] =grid[row][0] + bp[row-1][0];
        }
        //第一行的值等于原矩阵的第一行上依次相加
        for(int col = 1; col < grid[0].length;col++) {
            bp[0][col] =grid[0][col] + bp[0][col-1];
        }
        // 填表  row,col 位置的值 Math.min(bp[row-1][col],bp[row][col-1]) + grid[row][col]
        for(int row = 1 ; row < grid.length;row++) {
            for(int col = 1; col < grid[0].length; col++) {
                bp[row][col] = Math.min(bp[row-1][col],bp[row][col-1]) + grid[row][col];
            }
        }

        return bp[grid.length-1][grid[0].length-1];


    }

    /**
     * 空间压缩 O(min(m,n))
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int more = Math.max(grid.length,grid[0].length);
        int less = Math.min(grid.length,grid[0].length);

        boolean isRowBigger = grid.length >= grid[0].length;

        int[] arr = new int[less];
        arr[0] = grid[0][0];
        for(int i = 1; i< less ; i++) {
            arr[i] = arr[i-1] + (isRowBigger ? grid[0][i]  : grid[i][0] );
        }

        for (int i = 1; i < more; i++) {
            arr [0] = arr[0] + (isRowBigger ? grid[i][0] : grid[0][i]);

            for(int j = 1 ; j < less ;j++) {
                arr[j] = Math.min(arr[j-1],arr[j]) + (isRowBigger ? grid[i][j] : grid[j][i]);
            }
        }

        return arr[less-1];


    }
}
