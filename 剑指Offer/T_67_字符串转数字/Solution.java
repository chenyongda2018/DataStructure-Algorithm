package T_67_字符串转数字;

public class Solution {


    public int StrToInt(String str) {
        if(str == null || str.length() <=0) return 0;
        int fuhao = 0;
        if(str.charAt(0) == '-') fuhao = 1; //检查第一个符号
        int sum = 0;
        for(int i = fuhao;i < str.length();i++) {
            char c = str.charAt(i);
            if (c == '+') continue;
            if(c < 48 || c> 57) return 0; //检查每个字符的合法性
            sum = sum*10 + (c-48);

        }
        return fuhao == 0 ? sum : -sum;


    }
}
