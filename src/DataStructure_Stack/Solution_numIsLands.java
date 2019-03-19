package DataStructure_Stack;


/**
 * 深度优先遍历应用-岛屿的个数
 */
public class Solution_numIsLands {

    public static void dfsSearch(char[][] grid,int i,int j,int cols,int rows) {
        if (grid == null || i >= rows || j >= cols || i< 0 || j< 0) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfsSearch(grid,i+1,j,cols,rows);
        dfsSearch(grid,i,j+1,cols,rows);
        dfsSearch(grid,i-1,j,cols,rows);
        dfsSearch(grid,i,j-1,cols,rows);

    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length ==0) {
            return 0;
        }
        int cols = grid[0].length; //列数
        int rows = grid.length; //行数
        for (int i=0;i< rows;i++) {
           for (int j=0;j < cols;j++) {
               if (grid[i][j] == '1') {
                   count ++;
                   dfsSearch(grid,i,j,cols,rows);
               }
           }
        }
        return count;

    }


}
