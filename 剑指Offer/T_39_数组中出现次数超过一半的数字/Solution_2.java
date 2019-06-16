package T_39_数组中出现次数超过一半的数字;

public class Solution_2 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (!checkInvalidArray(array)) {
            return 0;
        }
        int times = 1;
        int result = array[0];

        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (result == array[i]) {
                times++;
            } else {
                times--;
            }
        }
        if (!checkMoreThanHalf(array,result )) {
            return 0;
        }
        return result;
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
}
