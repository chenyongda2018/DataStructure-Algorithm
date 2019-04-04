package T3_二维数组查找;

/**
 * Created by cyd on 19-4-4.
 */

public class FindInPartiallySortedMatrix {

    public static boolean find(int[][] matrix,int target) {
        if (matrix != null) {
            int rows = matrix.length;
            int columns = matrix[0].length;
            int row = 0;
            int column = columns-1;

            while (row < rows && column >= 0) {
                int rightUpNum = matrix[row][column];
                if (target == rightUpNum) {
                    return true;//找到了
                } else if (target > rightUpNum) {
                    row++;
                } else {
                    column--;
                }
            }
        } else {
            return false;//数组不合法
        }

        return false;//没找到
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{5,8,11,15}};
        System.out.println(find(matrix,100));
    }
}
