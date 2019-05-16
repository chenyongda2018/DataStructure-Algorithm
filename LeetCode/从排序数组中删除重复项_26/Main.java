package 从排序数组中删除重复项_26;

/**
 * Created by cyd on 19-5-15.
 */

public class Main {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int i = 0;
        for (int j = 1; j < nums.length ; j++) {
            if (nums[j] !=nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;

    }


    public static void main(String[] args) {
        int[]  nums= new int[]{1,1,2};
        int result = new Main().removeDuplicates(nums);
        for(int i : nums){
            System.out.println(i);
        }
        System.out.println(result);
    }
}
