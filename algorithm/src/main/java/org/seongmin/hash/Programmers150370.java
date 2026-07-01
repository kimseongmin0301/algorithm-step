package org.seongmin.hash;
import java.util.*;

/**
 *
 * 프로그래머스 개인정보 수집 유효기간
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 * */

public class Programmers150370 {
    public  static void main(String[] args) {

    }

    private static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            Map<String, Integer> map = new HashMap<>();

            // 1. 약관 종류별 보관 개월 수 저장
            for (String t : terms) {
                String[] temp = t.split(" ");
                map.put(temp[0], Integer.parseInt(temp[1]));
            }

            // 2. 오늘 날짜를 일수로 변환
            int todayDay = convertDay(today);

            // 3. 파기 대상 번호 저장
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < privacies.length; i++) {
                String[] temp = privacies[i].split(" ");

                String privacyDate = temp[0];
                String type = temp[1];

                int startDay = convertDay(privacyDate);
                int termMonth = map.get(type);

                // 수집일 + 보관기간 <= 오늘이면 파기 대상
                if (startDay + termMonth * 28 <= todayDay) {
                    result.add(i + 1);
                }
            }

            // 4. List<Integer> -> int[]
            int[] answer = new int[result.size()];

            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }

            return answer;
        }

        private int convertDay(String date) {
            String[] temp = date.split("\\.");

            int year = Integer.parseInt(temp[0]);
            int month = Integer.parseInt(temp[1]);
            int day = Integer.parseInt(temp[2]);

            return year * 12 * 28 + month * 28 + day;
        }
    }
}

