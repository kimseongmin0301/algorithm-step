package org.seongmin.queue_stack;

import java.util.Stack;

/**
 *
 * Leetcode daily-temperatures
 * https://leetcode.com/problems/daily-temperatures/
 *
 *
 * 단순히 해결하면 각 날짜마다 뒤쪽 날짜를 모두 확인해야 하므로
 * 시간복잡도는 O(N^2)이 된다.
 *
 * Stack을 사용하면 아직 더 따뜻한 날을 찾지 못한 날짜의 index를 저장해두고,
 * 현재 온도가 Stack top index의 온도보다 높을 때 해당 index의 정답을 계산한다.
 *
 * 정답은 현재 index - 이전 index 이며,
 * 각 index는 Stack에 한 번 들어가고 한 번 나오므로 시간복잡도는 O(N)이다.

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

