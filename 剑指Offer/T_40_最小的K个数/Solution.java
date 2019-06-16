package T_40_最小的K个数;


import java.lang.*;
import java.util.*;

/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

/**
 * 解法一:基于快速排序的partition函数,把比第k个数字小的移到它的左边，把比它大的移到右边。
 *        这样得到索引 k-1和之前 的数字就是最小的k个数
 *
 * 时间复杂度:O(n)
 * 缺点:对数组继续了修改
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if(!checkInvalidArray(input) || k > length || k <= 0 ) {
            return result;
        }

        int index = partition(input,length,0,input.length-1);
        int start = 0;
        int end = length - 1;
        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
                index = partition(input,length,start,end);
            } else {
                end = index - 1;
                index = partition(input,length,start,end);
            }
        }
        for (int i = 0;i <= index ;i++) {
            result.add(input[i]);

        }
        return result;
    }

    public boolean checkInvalidArray(int[] array) {
        if (array == null || array.length <= 0) {
            return false;
        }
        return true;
    }

    //生成指定范围内的随机数
    public int randomInRange(int start,int end) {
        int num = start + (int)(Math.random()*(end-start));
        return num;
    }

    public int partition(int[] data,int length,int start,int end) {
        int index = randomInRange(start,end);
        int small = start - 1;
        swap(data,index,end);
        for (index = start;index <= end;index++) {
            if (data[index] < data[end]) {
                small++;
                swap(data,small,index);
            }
        }
        small++;
        swap(data,small,end);
        return small;
    }

    public void swap(int[] data,int a,int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
