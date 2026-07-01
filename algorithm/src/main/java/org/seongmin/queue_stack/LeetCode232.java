package org.seongmin.queue_stack;

import java.util.Stack;

/**
 *
 * Leetcode implement-queue-using-stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * */

public class LeetCode232 {
    public  static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();

                if (c == ')' && open != '(') return false;
                if (c == '}' && open != '{') return false;
                if (c == ']' && open != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}

