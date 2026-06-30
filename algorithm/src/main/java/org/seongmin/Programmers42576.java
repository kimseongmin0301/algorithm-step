package org.seongmin;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 프로그래머스 완주하지 못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * */

public class Programmers42576 {
    public  static void main(String[] args) {

    }

    private static class Solution {
        public String solution(String[] participant, String[] completion) {

            // 참가자 명단 삽입
            Map<String, Integer> map = new HashMap<>();
            for(String p : participant) {
                // 동명이인 추가
                map.put(p, map.getOrDefault(p, 0) + 1);
            }

            // 완주자 체크
            for(String c : completion) {
                map.put(c, map.get(c) - 1);
            }

            // 완주자는 참가자보다 1명이 적기에 0이 아닌 key를 찾으면 됨
            return map.entrySet()
                    .stream()
                    .filter(e -> e.getValue() != 0)
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElseThrow();
        }
    }
}

