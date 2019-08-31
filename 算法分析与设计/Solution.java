import java.util.Arrays;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//
//            int a = in.nextInt();
//
//            System.out.println(a + b);
        System.out.println(getResult(5,3));
        }


    public static int getResult(int num,int m) {
        if(num == 1) return num;
        return (int)((getResult(num-1,m) + m -1) % num+1);
    }
    public static int reverse(int num) {
        if(num <Integer.MIN_VALUE || num > Integer.MAX_VALUE) return 0;
        if(num == 0 || (num >= -9 && num <=9 )) return num;
        String str = String.valueOf(num);
        char c = str.charAt(0);
        boolean isFuhao = false;
        if(c == '-' || c== '+') {
            isFuhao = true;
        }
        str = isFuhao ? str.substring(1) : str;

        char[] chars = str.toCharArray();

        int i = 0,j = chars.length-1;
        while(i < j ) {
            swap(chars,i,j);i++;j--;
        }
        str = getStr(chars);
        str = isFuhao ? c+str : str;
        int result = Integer.valueOf(str);
        return result;
    }

    public static void swap(char[] chars,int i,int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static String getStr(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for(char  c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

}
