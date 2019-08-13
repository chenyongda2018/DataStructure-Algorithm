package T_10_1_斐波那契数列;

public class Solution {


    /**
     * 循环实现
     * @param n
     * @return
     */
    public long Fibonacci(int n) {
        if (n<=0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        long one = 1;
        long two = 1;
        long sum = 0;
        for (long i = 2; i <= n; i++) {
            sum = one + two ;
            one = two;
            two = sum;
        }
        return sum;
    }
    /**
     * 递归实现(不推荐)
     * @param n
     * @return
     */
    public int FibonacciRecursive(int n) {
        if (n<=0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        return FibonacciRecursive(n-1)+FibonacciRecursive(n-2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Fibonacci(2));
    }
}
