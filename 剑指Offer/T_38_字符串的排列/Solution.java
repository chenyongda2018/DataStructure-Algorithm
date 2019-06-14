package T_38_字符串的排列;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 */

public class Solution {

    public ArrayList<String> Permutation(String str) {
        if(str == null) {
            return null;
        }
        char[] strs = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        permutationHelper(strs,0,list);
        Collections.sort(list);
        return list;
    }

    public void permutationHelper(char[] strs,int begin,ArrayList<String> list) {
        if (begin > strs.length -1 || begin < 0 ) {
            return;
        }
        if (begin == strs.length - 1) {
            String val = String.valueOf(strs);
            if (!list.contains(val)) {
                list.add(val);
            }

        }else {
            for (int j = begin; j < strs.length;j++) {
                swap(strs,begin,j);
                permutationHelper(strs,begin+1,list);
                swap(strs,begin,j); //恢复原样，以便下次交换
            }
        }

    }

    public void swap(char[] strs,int i,int j){
        char temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }
}
