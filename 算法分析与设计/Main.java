import java.util.Arrays;

public class Main {


    //第二题
    public static int maxDistToClosest(int[] seats) {

        //寻找最长0序列
        if(seats == null) return 0;
        int index = 0;

        int zeroLength = 0; //记录临时的 0序列长度
        int max = Integer.MIN_VALUE; //记录最长0序列长度
        //start记录 最长0序列的起始位置
        //end  最长0序列的终点位置
        int start = 0,end = 0;
        for (int i = 0; i < seats.length; i++) {
            if(seats[i] == 0) {
                zeroLength ++;
                if(zeroLength > max) {
                    end = i;
                }
            } else {
                if(zeroLength > max) {
                    max = zeroLength;
                }
                //遇到1 临时长度 清零
                zeroLength = 0;
            }
        }

        max = Math.max(max,zeroLength);
        start = end - max+1;

        //如果0序列在左半边,如 : 0,0,0,0,1,0,1
        //或者在右半边 : 1.0.1,0,0,0,0
        //则直接返回max
        if(end  == seats.length - 1 || start == 0) {
            return max;
        }
        //最长0序列在中间 如 0,1,0,0,0,0,1,0
        //根据max 奇偶，返回/2
        if(max % 2 == 0) {
            return max / 2;
        } else  {
            return (max+1)/2;
        }

    }












    //第一题
    public static int candy(int[] ratings) {
        if(ratings == null) return 0;
        int length = ratings.length;

        if(length == 1) return length;

        System.out.println(Arrays.toString(ratings));
        int count = 0;
        int[] candy = new int[length];

        for(int i = 0; i< candy.length; i++) {
            candy[i] = 1;
        }

        if(ratings[0] > ratings[1]) candy[0]++;

        for (int i = 1; i < length-1; i++) {
            if(ratings[i] > ratings[i-1] || ratings[i] > ratings[i+1]) {
                candy[i] = Math.max(candy[i-1],candy[i+1])+1;
            }
        }
        if(ratings[length-1] > ratings[length-2]) candy[length-1]++;

        for (int i = 0; i < candy.length; i++) {
            count+=candy[i];
        }
        return count;

/******************************结束写代码******************************/
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,0,0,1};
        int result = candy(arr);
        System.out.println(result);
    }
}
