package T_49_丑数;

/**
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，
 * 但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution {

    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        int[] mutilply2Numbers = new int[index];
        int number2Index = 0;
        mutilply2Numbers[0] = 2;
        int[] mutilply3Numbers = new int[index];
        int number3Index = 0;
        mutilply3Numbers[0] = 3;
        int[] mutilply5Numbers = new int[index];
        int number5Index = 0;
        mutilply5Numbers[0] = 5;

        while (nextUglyIndex < index) {
            int min = getMin(uglyNumbers[number2Index]*2, uglyNumbers[number3Index]*3, uglyNumbers[number5Index]*5);
            uglyNumbers[nextUglyIndex] = min;

            while (uglyNumbers[number2Index] *2 <= min) {
                mutilply2Numbers[number2Index] =uglyNumbers[number2Index] *2;
                number2Index++;
            }

            while (uglyNumbers[number3Index] *3 <= min) {
                mutilply3Numbers[number3Index] =uglyNumbers[number3Index] *3;
                number3Index++;
            }

            while (uglyNumbers[number5Index] *5 <= min) {
                mutilply5Numbers[number5Index] =uglyNumbers[number5Index] *5;
                number5Index++;
            }
            nextUglyIndex++;
        }

        int result = uglyNumbers[nextUglyIndex-1];
        return result;
    }

    public int getMin(int num1, int num2, int num3) {
        int miner = (int) (Math.min(num1, num2));
        return (int) (Math.min(miner, num3));
    }

}
