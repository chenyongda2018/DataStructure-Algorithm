package 总持续时间可被60整除的歌曲_1010;

public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        for (int i = 0; i < time.length-1; i++) {
            for (int j = i+1; j <time.length ; j++) {
                if ((time[i]+time[j])%60 == 0) {
                    result++;
                }
            }
        }
        return result;
    }


}
