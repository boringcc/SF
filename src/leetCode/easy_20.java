package leetCode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 输入: "()"
 输出: true
 输入: "()[]{}"
 输出: true
 输入: "(]"
 输出: false

 */
public class easy_20 {
    public boolean isValid(String s) {
        char[] s1 = s.toCharArray();
        if (s1.length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] == '(' || s1[i] == '[' || s1[i] == '{') {
                stack.push(s1[i]);
            }
            if (s1[i] == ')') {
                if(!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
            if (s1[i] == ']') {
                if(!stack.isEmpty()) {
                    if (stack.peek() == '[') {
                        stack.pop();
                    }
                }
            }
            if (s1[i] == '}') {
                if(!stack.isEmpty()) {
                    if (stack.peek() == '{') {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
