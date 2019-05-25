package T_16_数值的整数次方;

public class Solution {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } //当指数为 0 返回1
        if (exponent > 0) {
            return powerPositive(base, exponent);
        } // 当指数大于0
        if (base == 0) {
            return 0;
        } // 当指数小于0，且基数为0时，为特殊情况

        //当基数不为0，指数小于0
        return 1.0f/powerPositive(base, -exponent);

    }

    public double powerPositive(double base,int exponent) {
        if (exponent == 1) {
            return  base;
        }
        double product = powerPositive(base,exponent >> 1 );
        product *= product;
        if((exponent & 0x1) == 1) {
            product*=base;
        }

        return product;
    }




    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.Power(2,-10 ));
    }
}
