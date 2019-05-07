package 查找常用字符_1002;

import java.util.ArrayList;
import java.util.List;

/**
 * 网上解题思路:
 * 对每个字符串得出它的 字符数量集 [x,n] x元素出现n次
 * 然后对所有的字符数量集求交集
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] res = new int[26];
        char[] firstArr = A[0].toCharArray();
        for (char c : firstArr) {
            res[c - 'a']++;
        } // 先添加第一个字符串的 字符数量集

        for (int i = 1; i < A.length; i++) {
            int[] temp = new int[26];
            for (char c : A[i].toCharArray()) {
                temp[c - 'a']++;
            } // 每个字符串的 字符数量集

            for (int j = 0; j < 26; j++) {
                res[j] = Math.min(res[j], temp[j]);
            } // 求交集
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                for (int j = 0; j < res[i]; j++) {
                    String s = (char)(i+'a') + "";
                    result.add(s);
                }
            }
        }

        return result;

    }
}
