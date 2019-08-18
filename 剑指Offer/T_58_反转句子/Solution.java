package T_58_反转句子;

public class Solution {

    public String ReverseSentence(String str) {
        if(str == null||str.trim().equals("")) return str;
        String[] arr = str.split(" ");
        int len = arr.length-1;
        int i = 0;

        StringBuilder sb = new StringBuilder();
        for (int j = len; j >=0 ; j--) {

            if( j == 0) { //最后一个单词不加空格
                sb.append(arr[j]);
            }else {
                sb.append(arr[j]).append(" ");//其他单词加空格
            }

        }
        return sb.toString();
    }


}
