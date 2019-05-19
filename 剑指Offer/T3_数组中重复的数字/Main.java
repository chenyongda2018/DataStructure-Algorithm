package T3_数组中重复的数字;

public class Main {


    public static void main(String[] args) {
        int num = duplicateNum(new int[]{2,2,3,4,5,6,6});
        System.out.println(num);
    }

    /**条件：长度为n的数组，各元素在0~n-1范围，
     * 思路:
     * 1.假设数组有序，且无重复，则下标为i的位置上它的值就是i本身
     * 2.从开始下标i开始检验，如果 i位置的值等于i，证明此位置上的元素在它该在的位置上(比较听话) 则i++,往下遍历
     * 3.如果 i位置的值(a = nums[i]) 不等于i，找到下标为i位置的值的元素 (b = nums[a])，若b = a,则出现重复元素
     * 4.如果3中 b 不等于a，则说明a占了b应该在的位置，交换a,b，让b归位.
     * 5.重复 2 -4步骤
     *
     * @param nums
     * @return
     */

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
