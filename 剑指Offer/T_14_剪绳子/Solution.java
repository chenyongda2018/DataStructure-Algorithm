package T_14_剪绳子;

public class Solution {

    /**
     * 思路:长度等于4时，切成2*2，大于5时，切成3个3个的
     * 贪婪算法
     *
     * @param length
     * @return
     */
    public int cutting_solution2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }

        if (length == 3) {
            return 2;
        }
        int countOf3 = length / 3;
        //当剩下4个的时候，切成2*2
        if (length - countOf3 * 3 == 1) {
            countOf3--;
        }
        int countOf2 = (length - countOf3 * 3)/2;

        return (int)(Math.pow(3,countOf3 )* Math.pow(2,countOf2 ));


    }

    public int cutting_solution1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }

        if (length == 3) {
            return 2;
        }

        int max = 0;
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i <= length; i++) {
            for (int j = 1; j <= length / 2; j++) {
                int num = products[j] * products[i - j];
                if (max < num) {
                    max = num;
                }
                products[i] = max;
            }

        }
        max = products[length];
        return max;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.cutting_solution2(8));
    }
}
