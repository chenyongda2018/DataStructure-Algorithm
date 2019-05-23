package T_15_二进制中1的个数;

public class Solution {

    //解法1
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag > 0) {
            if ((flag & n) == flag) {
                count++;
            }
            flag = flag << 1;
        }

        return count;
    }

    //解法2
    public int NumberOf1_solution2(int n) {
        int count  = 0;
        while ((n & (n-1)) > 0) {
            count ++ ;
            n --;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.NumberOf1_solution2(10));
    }
}
