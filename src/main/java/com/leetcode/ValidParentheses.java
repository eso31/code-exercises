package com.leetcode;


import java.util.Stack;

/***
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(())")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("){")); // false
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.empty() || !isValidPair(c, stack.pop())) {
                        return false;
                    }
                    break;
            }
        }
        return stack.empty();
    }

    private static boolean isValidPair(char close, char open) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
