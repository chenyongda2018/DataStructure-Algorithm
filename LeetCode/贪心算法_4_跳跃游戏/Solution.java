package 贪心算法_4_跳跃游戏;

public class Solution {

    public boolean canJump_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int length = 0;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (nums[i] == 0) {
                for (int j = i-1; j >=0 ; j--) {
                    if (nums[j] > i-j) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }
}
