package T_19_正则表达式匹配;

/**
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, pattern, 0);

    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int ptnIndex) {
        //当两者都匹配到最后长度，说明匹配成功
        if (strIndex == str.length && ptnIndex == pattern.length) {
            return true;
        }

        if (strIndex != str.length && ptnIndex == pattern.length) {
            return false;
        }

        if (ptnIndex + 1 < pattern.length && pattern[ptnIndex + 1] == '*') { // 如果匹配串的第二位是*
            //如果字符串与匹配串的第一个字符能够匹配
            if ( strIndex != str.length && pattern[ptnIndex] == str[strIndex] || (strIndex != str.length && pattern[ptnIndex] == '.' )) {
                return matchCore(str, strIndex, pattern, ptnIndex + 2) || // * 号匹配零次时
                        matchCore(str, strIndex + 1, pattern, ptnIndex + 2) || // * 号 匹配1次时
                        matchCore(str, strIndex + 1, pattern, ptnIndex); //  * 号匹配无数次时
            } else {
                //如果字符串与匹配串的第一个字符不能匹配
                return matchCore(str, strIndex, pattern, ptnIndex + 2);
            }
        }

        if ( (strIndex != str.length && pattern[ptnIndex] == str[strIndex]) || (pattern[ptnIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, ptnIndex + 1);
        }
        return false;

    }




    public static void main(String[] args) {
        char[] str = new char[]{};
        char[] pattern = new char[]{'.', '*'};
        Solution s = new Solution();
        System.out.println(s.match(str, pattern));
    }
}
