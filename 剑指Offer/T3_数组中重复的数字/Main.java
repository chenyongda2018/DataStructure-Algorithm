package T3_数组中重复的数字;

public class Main {


    public static void main(String[] args) {
        int num = duplicateNum(new int[]{2,2,3,4,5,6,6});
        System.out.println(num);
    }

    public static int duplicateNum(int [] nums) {
        if (nums == null || nums.length<=0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <0 || nums[i] >=nums.length) {
                return -1;
            }
        }

        int index = 0;
        while (index < nums.length) {
            //先看 index位置上的数 是否为 index
            int value = nums[index];
            if(value  == index) {
                index++; //如果 index位置上的数就是index,则继续遍历
            } else { //如果index位置上的数不是index
                if (value == nums[value]) { // 比较下标为index的值和下标为value的值,若相等，则出现重复
                    return value;
                } else {
                    //如果不重复，则交换两者
                    int temp = value;
                    nums[index] = nums[value];
                    nums[value] = temp;
                }
            }
        }
        return -1;
    }
}
