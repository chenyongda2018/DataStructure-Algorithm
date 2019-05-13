package 递归求a的n次方;

public class Solution {
    public static void main(String[] args) {
        System.out.println(pow(2,2 ));
    }

    public static double pow(double a, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a;
        }
        return pow(a, n % 2) * pow(a,(n-n%2)/2 ) * pow(a,(n-n%2)/2 );
    }
}
