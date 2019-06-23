package T_51_数组中的逆序对;

/**
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Solution {
    public int InversePairs(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }

        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }

        long result = inversePairs(array, copy, 0, array.length - 1);
        return (int)(result%1000000007);
    }

    public long inversePairs(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;

        long leftCount = inversePairs(copy, data, start, start + length);
        long rightCount = inversePairs(copy, data, start + length + 1, end);
        int endCopy = end;
        int i = start + length;
        int j = end;
        long count = 0;
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[endCopy--] = data[i--];
                count += j - (start + length);
            } else {
                copy[endCopy--] = data[j--];
            }
        }

        while (i >= start) {
            copy[endCopy--] = data[i--];
        }
        while (j >= start + length + 1) {
            copy[endCopy--] = data[j--];
        }

        long result = leftCount + rightCount + count;

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.InversePairs(new int[]{1,2,3,4,5,6,7,0});
        System.out.println(result);
    }
}
