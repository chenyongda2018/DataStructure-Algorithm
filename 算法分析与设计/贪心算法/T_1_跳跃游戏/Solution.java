package 贪心算法.T_1_跳跃游戏;

/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */
class Solution {
    //贪心思想
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 1) {
            return false;
        }

        int lastGoodPosition = nums.length -1;//指向最左边的能够到达终点的元素位置,最后要判断这个位置是否为0
        for (int i=nums.length-1; i >= 0 ; i--) {
            if (nums[i] + i >= lastGoodPosition) {
                lastGoodPosition = i;
            }
        }

        return lastGoodPosition == 0;
    }
}
