package T_58_2_左旋转字符串;

public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.trim().equals("") || n < 1) return str;
        String pre = str.substring(0,n);
        String str2 = str.substring(n,str.length());
        return str2+pre;

    }


}
