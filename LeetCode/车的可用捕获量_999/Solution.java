package 车的可用捕获量_999;

public class Solution {
    public int numRookCaptures(char[][] board) {
        int pawnCount = 0;
        if (board == null || board.length == 0) {
            return pawnCount;
        }
        int ci = 0, cj = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //找到车的位置
                if (board[i][j] == 'R') {
                    ci = i;
                    cj = j;
                    break;
                }
            }
        }

        //往左方遍历
        for (int k = ci; k >= 0; k--) {
            char left = board[ci][k];
            if (left == 'B') {
                break;
            } else if (left == 'p') {
                pawnCount++;
                break;
            }
        }

        //往右方遍历
        for (int k = ci; k < board.length; k++) {
            char right = board[ci][k];
            if (right == 'B') {
                break;
            } else if (right == 'p') {
                pawnCount++;
                break;
            }
        }

        //往上方遍历
        for (int k = cj; k >= 0; k--) {
            char top = board[k][cj];
            if (top == 'B') {
                break;
            } else if (top == 'p') {
                pawnCount++;
                break;
            }
        }

        //往下方遍历
        for (int k = cj; k < board.length; k++) {
            char down = board[k][cj];
            if (down == 'B') {
                break;
            } else if (down == 'p') {
                pawnCount++;
                break;
            }
        }


        return pawnCount;

    }
}
