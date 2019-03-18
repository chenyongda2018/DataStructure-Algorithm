package DataStructure_Stack;

import java.util.Stack;

/**
 * leetCode_有效的符号
 */
public class Solution_Valid_String {

    public static boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (char c : ch) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {

                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("([)]"));


    }
}
