package T_12_矩阵中的路径;
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length <= 0 || rows <= 0 || cols <= 0 || str == null || str.length <= 0) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }


        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {

        if (pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
            pathLength++;
            visited[row * cols + col] = true;
            if (hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)) {
                hasPath = true;
            }
            if (!hasPath) {
                pathLength--;
                visited[row * cols + col] = false;
            }

        }
        return hasPath;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[] matrix = new char[]{'A','B','C','E',
                                   'S','F','C','S',
                                   'A','D','E','E'};
        int rows = 3;
        int cols = 4;
        char[] str = new char[]{'A','B','C','C','E','D'};
        System.out.println(s.hasPath(matrix, rows,cols , str));
    }


}
