package Chapter_3_二叉树.T_5_递归动态规划.T_1_斐波那契数列相关问题;

public class Solution {
    //时间复杂度 o(n)
    public static int fib (int n) {
        if( n < 3) return 1;
        int one = 1;
        int two = 1;
        int sum = 0;
        for (int i = 3; i <= n ; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }

    public static int fib2(int n) {
        double one = Math.pow((1+Math.sqrt(5))/2,n);
        double two = Math.pow((1-Math.sqrt(5))/2,n);
        return (int)((one-two)/Math.sqrt(5));
    }



    public static void main(String[] args) {
        System.out.println(fib2(5));
    }
}
