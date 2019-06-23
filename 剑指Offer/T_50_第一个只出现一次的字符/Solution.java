package T_50_第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null) {
            return -1;
        }
        LinkedHashMap<Character,Integer> hashMap = new LinkedHashMap<Character, Integer>();
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            if (hashMap.containsKey(strArray[i])) {
                int value = hashMap.get(strArray[i]);
                hashMap.put(strArray[i],value+1 );
            } else {
                hashMap.put(strArray[i],1 );
            }
        }

        char onceChar = ' ';

        for (Map.Entry<Character,Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                onceChar = entry.getKey();
                break;
            }
        }

        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i] == onceChar) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int reuslt = s.FirstNotRepeatingChar("google");
        System.out.println(reuslt);

    }
}
