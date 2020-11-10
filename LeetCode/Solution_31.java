import java.util.Arrays;

public class Solution_31 {
    public void nextPermutation(int[] nums) {

        if(nums.length == 1) return;
        for (int i = nums.length-1; i > 0; i--) {
            if(nums[i-1] < nums[i]) {
                Arrays.sort(nums,i,nums.length);
                for (int j = i; j < nums.length; j++) {
                    if(nums[j] > nums[i-1]) {
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }
}
