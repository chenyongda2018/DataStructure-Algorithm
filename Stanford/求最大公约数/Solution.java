package 求最大公约数;

public class Solution {

    public static int gdc(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a >= b) {
            return gdc(a - b, b);
        } else {
            return gdc(a, b - a);
        }
    }

    public static void main(String[] args) {
        System.out.println(gdc(8,3));
    }
}
