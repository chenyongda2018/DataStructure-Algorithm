package T_39_数组中出现次数超过一半的数字;

import java.lang.*;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution_1 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (!checkInvalidArray(array)) {
            return 0;
        }
        int index = partition(array,array.length,0,array.length-1);
        int half = (array.length -1 ) >> 1;
        int start = 0;
        int end = array.length -1;
        while (index != half) {
            if (index < half ) {
                start = index +1;
                index = partition(array,array.length,start,end);
            } else {
                end = index - 1;
                index = partition(array,array.length,start,end);
            }
        }
        if (!checkMoreThanHalf( array,array[index]) ){

            return 0;

        }
        return array[index];
    }



    public int partition(int data[],int length,int start,int end ) {
        int index = randomInRange(start,end);
        int small = start - 1;
        swap(data,index,end);
        for (index = start; index <= end;index++) {
            if (data[index] < data[end]) {
                small++;
                if (small != index) {

                    swap(data,small,index);
                }
            }
        }

        small++;
        swap(data,small,end);
        return small;
    }

    public boolean checkInvalidArray(int[] array) {
        if (array == null || array.length <= 0) {
            return false;
        }
        return true;
    }

    public boolean checkMoreThanHalf(int[] array,int num) {
        if (checkInvalidArray(array)) {
            int times = 0;
            for (int i = 0; i< array.length;i++) {
                if (array[i] == num) {
                    times++;
                }
            }

            if (times*2<= array.length) {
                return false;
            }

            return true;
        }
        return false;
    }

    //生成指定范围内的随机数
    public int randomInRange(int start,int end) {
        int num = start + (int)(Math.random()*(end-start));
        return num;
    }

    public void swap(int[] data,int a,int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }


    public static void main(String[] args) {
        Solution_1 s = new Solution_1();
        int[] dada = {2,2,2,2,2,1,3,4,5};
        System.out.println(s.MoreThanHalfNum_Solution(dada));
    }
}
