package org.seongmin.queue_stack;

import java.util.Stack;

/**
 *
 * Leetcode baseball-game
 * https://leetcode.com/problems/baseball-game/
 *
 * 스택을 이용한 문제
 * 케이스 별로 조건에 맞게 세팅.
 * 중요 포인트는 최근 2개의 숫자를 기억하는것
 * */

public class LeetCode682 {
    public  static void main(String[] args) {

    }

    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String o : operations) {
            switch (o) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int first = stack.pop();
                    int second = stack.peek();
                    stack.push(first);
                    stack.push(first + second);
                    break;
                default:
                    stack.push(Integer.valueOf(o));
                    break;
            }
        }

        int answer = 0;
        for(int score : stack) {
            answer += score;
        }

        return answer;
    }
}

