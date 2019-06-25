package 动态规划.T_1_不相邻元素之和的最大值;

public class Solution {
    //递归实现
    public int rec_opt(int[] data,int length) {
        if (data == null || data.length < 0) {
            return 0;
        }
        if (length == 1) {
            return data[0];
        }
        if (length == 2) {
            return Math.max(data[0],data[1]);
        }
        int A = rec_opt(data,length-2 ) + data[length-1];
        int B = rec_opt(data,length-1 );
        return Math.max(A,B);
    }
    //非递归实现
    public int noRec_opt(int[] data) {

        if (data == null || data.length < 0) {
            return 0;
        }
        int[] opt = new int[data.length];//备忘录,记录前i个元素产生的最大受益
        opt[0] = data[0];
        if (data.length == 2) {
            opt[1] = Math.max(data[0],data[1] );
        }

        for (int i = 2; i < data.length; i++) {
            int a = data[i] + opt[i-2];
            int b = opt[i-1];
            opt[i]  = Math.max(a, b);
        }
        return opt[data.length-1];
    }


    public static void main(String[] args) {
        Solution s= new Solution();

        int[] data = new int[]{1,2,4,1,7,8,3};
        System.out.println(s.noRec_opt(data));
    }
}
