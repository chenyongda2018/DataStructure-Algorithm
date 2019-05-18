## 剑指Offer题目3-二维数组查找

题目描述:给定一个二维数组,每一行从左到右递增,每一列从上到下递增,要求实现输入一个二维数组,和一个整数,返回这个二维数组中是否有这个整数.  

解题思路:  从二维数组的右上角开始找,若右上角这个数比target小,则舍弃当前右上角这个数所在的列  

若右上角的数比target大,则舍弃右上角数所在的行

```java
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
                    row++;//往下一行
                } else {
                    column--;//往左一行
                }
            }
        } else {
            return false;//数组不合法
        }

        return false;//没找到
    }
```

