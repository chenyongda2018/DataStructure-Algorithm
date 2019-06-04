package T_29_顺时针打印矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如:
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int cols = matrix[0].length;
        int rows = matrix.length;

        if ( rows == 0 || cols == 0) {
            return null;
        }
        int start = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (start * 2 < cols && start * 2 < rows) {
            addNumToList(matrix, cols, rows, start, list);
            start++;
        }

        return list;
    }

    public void addNumToList(int[][] matrix, int cols, int rows, int start, ArrayList list) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        //第一步:打印从左到右的一行
        for (int i = start; i <= endX;i++) {
            list.add(matrix[start][i]);
        }

        //第二步:打印从上到下的一列
        if(endY > start) {
            for (int i = start+1; i <= endY; i++) {
                list.add(matrix[i][endX]);
            }
        }

        //第三步:打印从右到左的一行
        if (endX > start && endY > start) {
            for (int i = endX-1; i >= start ; i--) {
                list.add(matrix[endY][i]);
            }
        }

        //第四步:打印从下到上的一列
        if (endY -2 >= start && endX > start) {
            for (int i = endY - 1; i >= start + 1 ; i--) {
                list.add(matrix[i][start]);
            }
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{{1},{2},{3},{4},{5}};
        List<Integer> list = s.printMatrix(matrix);
        for(int num : list) {
            System.out.print(num+" ");
        }
    }
}
