package 逆波兰表达式求值_150;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length < 1) return 0;
        Stack<String> stack = new Stack<>();
        int sum = 0;
        for(int i = 0; i< tokens.length;i++) {
            String s = tokens[i];
            if(isNum(s)) {
                stack.push(s);
            } else {
                String num2 = stack.pop();
                String num1 = stack.pop();
                String res = calculate(s,num1,num2);
                stack.push(res);
            }
        }
        return Integer.valueOf(stack.pop());


    }



    public boolean isNum(String str) {
        if(str.equals("+") ||str.equals("-") || str.equals("*") || str.equals("/") ) return false;
        return true;
    }


    public String calculate(String cal,String num1,String num2) {
        int n1 = Integer.valueOf(num1);
        int n2 = Integer.valueOf(num2);
        int res = 0;
        if(cal.equals("+")) {
            res = n1+n2;
        }
        if(cal.equals("-")) {
            res = n1-n2;
        }
        if(cal.equals("*")) {
            res = n1*n2;
        }
        if(cal.equals("/")) {
            res = n1/n2;
        }
        return String.valueOf(res);
    }
}
