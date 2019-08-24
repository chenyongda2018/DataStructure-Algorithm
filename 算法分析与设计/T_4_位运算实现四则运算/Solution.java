package T_4_位运算实现四则运算;

public class Solution {
    //加法
    public int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;

    }


    //减法
    public int minus(int a,int b ) {
        return add(a,getNeg(b));
    }


    //乘法
    public int multi(int a, int b) {
        int res = 0;
        while(b != 0) {
            if((b & 1) == 1) {
                res = add(res,a);
            }
            a = a << 1;
            b = b >>> 1; //无符号右移
        }
        return res;
    }


 //取反
    public int getNeg(int n) {
        return add(~n,1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().add(1,1));
        System.out.println(new Solution().minus(100,90));
        System.out.println(new Solution().multi(8,7));
    }
}
