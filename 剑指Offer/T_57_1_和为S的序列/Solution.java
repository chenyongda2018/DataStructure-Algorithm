package T_57_1_和为S的序列;

import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int left = 1;
        int right = 2;
        while(left < right) {
            int cur = ((left+right)*(right - left + 1))/2; //求和公式
            if(cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = left ; i <= right;i++){
                    list.add(i);
                }
                res.add(list);
                left++;
            } else if(cur < sum) { //如果当前序列和小于sum，则需要增大，right右移
                right++;
            } else {   //如果当前序列和大于sum，则需要减小，left右移
                left++;
            }
        }
        return res;


    }
}
