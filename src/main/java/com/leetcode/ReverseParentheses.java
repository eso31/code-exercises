package com.leetcode;


import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class ReverseParentheses {
    public static void main(String[] args) {
        System.out.println(reversedByParentheses("(abcd)")); // dcba
        System.out.println(reversedByParentheses("(u(love)i)")); // iloveu
        System.out.println(reversedByParentheses("(ed(et(oc))el)")); // leetcode
    }

    static String reversedByParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                char charFromStack = stack.pop();
                StringBuilder sb = new StringBuilder();

                while (charFromStack != '(') {
                    sb.append(charFromStack);
                    charFromStack = stack.pop();
                }

                String sHelper = sb.toString();

                if (stack.empty()) {
                    result.append(sHelper);
                } else {
                    for (int j = 0; j < sHelper.length(); j++) {
                        char ch = sHelper.charAt(j);
                        stack.push(ch);
                    }
                }
            } else if (stack.isEmpty() && c != '(') {
                result.append(c);
            } else {
                stack.push(c);
            }
        }
        return result.toString();
    }

}
