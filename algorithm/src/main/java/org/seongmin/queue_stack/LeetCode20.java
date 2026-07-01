package org.seongmin.queue_stack;

import java.util.*;

/**
 *
 * Leetcode valid-parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * 짝이 맞는 괄호를 찾아야 하기에 여는 괄호가 먼저 들어오는지 확인, 닫는 괄호가 나오면 false
 * 여는 괄호가 들어가고 닫는 괄호가 나왔으면 이전 괄호를 확인 후 짝이 맞는지 확인
 * */

public class LeetCode20 {
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

