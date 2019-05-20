package T10_2_青蛙跳台阶;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * f(n) = f(n-1) + f(n-2) + f(n-3) + ..+ f(1);
 * f(n-1) = f(n-2) + f(n-3) + ..+ f(1);
 * ∴ f(n) = 2f(n-1) = 4f(n-2) = 8(f-3)=...
 *    =2的n-1次方*f(1)
 */
public class Solution {
    public int JumpFloorII(int target) {
        return 1 << (target -1);
    }
}
