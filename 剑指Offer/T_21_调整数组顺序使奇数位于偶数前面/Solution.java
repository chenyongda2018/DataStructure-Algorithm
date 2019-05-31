package T_21_调整数组顺序使奇数位于偶数前面;

public class Solution {
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int head = 0;
        int tail = array.length - 1;

        while (head < tail) {
            if (head < tail && !isEven(array[head])) {
                head++;
            }
            if (head < tail && isEven(array[tail])) {
                tail--;
            }

            if (head < tail) {
                int temp = array[head];
                array[head] = array[tail];
                array[tail] = temp;
            }
        }

    }

    public boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
