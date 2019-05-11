package 二进制求和_67;

import java.util.Collections;

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if ( j >=0) {
                sum += b.charAt(j--) - '0';
            }
            result.append(sum % 2);
            carry = sum / 2; // 前一位加时 多出来的数
        }
        if(carry > 0) {
            result.append(carry);
        }
        return  result.reverse().toString();


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.addBinary("1011", "11");
        System.out.println(result);
    }
}
