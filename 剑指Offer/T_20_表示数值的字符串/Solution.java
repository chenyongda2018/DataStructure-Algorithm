package T_20_表示数值的字符串;

public class Solution {
    public boolean isNumeric(char[] str) {

        if (str == null) {
            return false;
        }

        int index = scanInteger(str);
        if (index == 0) {
            return false;
        }
        boolean numberic = true;
        int lastIndex = 0;
        if (index + 2 < str.length && str[index + 1] == '.') {
            index+=2;
            lastIndex = index;
            index = scanUnsignedInteger(str, index);
            numberic = (index >= lastIndex);


        }

        if (index + 2 < str.length && str[index] == 'e' || index+1 < str.length && str[index] == 'E') {
            index+=2;
            lastIndex = index;
            index = scanInteger(str);
            numberic = !(index == lastIndex);

        }

        return numberic && index == str.length - 1;

    }


    public int scanInteger(char[] str) {
        int index = 0;
        if (str[0] == '+' || str[1] == '-') {
            index++;
        }
        return scanUnsignedInteger(str, index);
    }

    public int scanUnsignedInteger(char[] str, int start) {
        //int count = 0
        while (start < str.length && str[start] >= '0' && str[start] <= '9') {
            //count++;
            start++;
        }
        return start - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isNumeric(new char[]{'1', '2', '3','.','4','5','e','+','6'}));
    }
}
