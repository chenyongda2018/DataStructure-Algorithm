package 查询后的偶数和_985;

public class Solution {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        if (A == null || queries == null || A.length < 1 ||
                A.length > 10000 || queries.length < 1 || queries.length > 10000) {
            return null;
        }
        /*
        先计算出A中偶数的和 evenSum
         */
        int evenSum = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                evenSum += a;
            }
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) { // i 为遍历次数
            int val = queries[i][0];
            int index = queries[i][1];
            int a = A[index]; //先获取A[index]位置改变之前的值
            A[index] += val; //单次遍历之后，添加元素完毕
            if (A[index] % 2 == 0) { //如果加法之后是偶数
                if (a % 2 == 0) { //原先的数是偶数
                    evenSum += val; //只加上 val
                } else { // 原先的数是奇数
                    evenSum += A[index]; //则加上最新的值
                }
            } else { //加上之后是奇数
                if (a % 2 == 0) { //原先的值是偶数
                    evenSum -= a; //去掉它
                }
            }
            answer[i] = evenSum;
        }
        return answer;
    }
}
