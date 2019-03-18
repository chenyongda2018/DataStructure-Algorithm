package DataStructure_Stack;


/**
 * leetCode_每日温度
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] t = new int[T.length];
        for (int i=0;i<T.length;i++) {
            int currentTem = T[i];
            for (int j = i+1; j < T.length; j++) {
                if ( T[j] > currentTem) {
                    t[i] = j-i;
                    break;
                }
                t[i] = 0;
            }
        }
        return t;
    }

    public static void main(String[] args) {

    }
}
