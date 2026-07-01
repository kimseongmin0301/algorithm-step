package org.seongmin.hash;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 프로그래머스 의상
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * */

public class Programmers42578 {
    public  static void main(String[] args) {

    }

    private static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;

            // 종류 별로 몇개가 있나 더하기
            Map<String, Integer> map = new HashMap<>();
            for(String[] type : clothes) {
                map.put(type[1], map.getOrDefault(type[1], 0) + 1);
            }

            // 안입는 경우도 있으니 종류별 값에 +1을 해줘서 전체를 곱하면 전체 가지수가 나옵니다
            // 최소 1개는 입어야 하기에 -1을 해서 경우의 수를 구합니다
            for (int count : map.values()) {
                answer *= count + 1;
            }

            return answer - 1;
        }
    }
}

