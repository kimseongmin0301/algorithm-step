package org.seongmin;
import java.util.*;

/**
 *
 * 프로그래머스 신고 결과 받기
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 * */

public class Programmers92334 {
    public  static void main(String[] args) {

    }

    private static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            // 중복 신고 제거 Set
            Set<String> set = new HashSet<>();

            // 결과 분리 map
            Map<String, Integer> reportCnt = new HashMap<>();
            Map<String, Integer> mailCnt = new HashMap<>();

            // 중복제거
            for (String r : report) {
                set.add(r);
            }

            // 결과 정리
            for (String r : set) {
                String[] temp = r.split(" ");

                String to = temp[1];

                reportCnt.put(to, reportCnt.getOrDefault(to, 0) + 1);
            }

            for (String r : set) {
                String[] temp = r.split(" ");

                String from = temp[0];
                String to = temp[1];

                if(reportCnt.get(to) >= k) {
                    mailCnt.put(from, mailCnt.getOrDefault(from, 0) + 1);
                }
            }

            int[] answer = new int[id_list.length];
            for (int i = 0; i < id_list.length; i++) {
                answer[i] = mailCnt.getOrDefault(id_list[i], 0);
            }

            return answer;
        }
    }
}

