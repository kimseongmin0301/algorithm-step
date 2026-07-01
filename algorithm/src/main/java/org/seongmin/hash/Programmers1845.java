package org.seongmin.hash;

import java.util.*;

/**
 *
 * 프로그래머스 폰켓몬
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * */

public class Programmers1845 {
    public  static void main(String[] args) {

    }

    private static class Solution {
        public int solution(int[] nums) {
            Set<Integer> set = new HashSet<>();

            // 폰켓몬 같은 종류 제거 삽입
            for (int num : nums) {
                set.add(num);
            }

            // 최대 가질 수 있는 폰켓몬 수
            int maxPick = nums.length / 2;

            // 선택 가능한 개수 vs 종류의 개수 의 최솟값
            return Math.min(set.size(), maxPick);
        }
    }
}

