package org.seongmin.queue_stack;

import java.util.Stack;

/**
 *
 * Leetcode daily-temperatures
 * https://leetcode.com/problems/daily-temperatures/
 *
 *
 * 간단히 해결하면 이중 for로 시간복잡도 O(n2) 이 되지만
 * Stack을 사용하면 O(n)으로 해결이 가능하다.
 *
 * Stack에 index 값을 넣어 temperatures 의 값을 찾고 정답 index 에서 현재 index를 빼서
 * 출력 배열에 넣어 해결
 * */

public class LeetCode739 {
    public  static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }

            stack.push(i);
        }

        return answer;
    }
}

