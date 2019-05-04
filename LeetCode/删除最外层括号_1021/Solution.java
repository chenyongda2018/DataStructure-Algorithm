package 删除最外层括号_1021;

import java.util.Stack;



public class Solution {
    public String removeOuterParentheses(String S) {
        if (S == null || S.length() > 10000 || S.length() <=0) {
            return null;
        }
        Stack s = new Stack();
        StringBuilder res = new StringBuilder("");
        for (char c : S.toCharArray()) {
            if (c == '(') {
                s.push(c);
                if (s.size() > 1) {
                    res.append(c);
                }
            } else {
                if (s.size() > 1) {
                    res.append(c);
                }
                s.pop();
            }
        }
        return res.toString();
    }
}
