package org.seongmin;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 프로그래머스 문자열 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108
 * */

public class Programmers140108 {
    public  static void main(String[] args) {

    }

    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int diff = 0;
        char x = ' ';

        for (int i =0; i < s.length(); i++) {
            // 초기 세팅
            if (same == 0 && diff == 0) {
                x = s.charAt(i);
            }

            // 처음 문자와 같은지 아닌지 판별
            if(x == s.charAt(i)) {
                same++;
            } else {
                diff++;
            }

            // 같으면 답 증가, 초기화
            if(same == diff) {
                answer++;
                same = 0;
                diff = 0;
            }
        }

        // 마지막까지 나누어 지지 않았으면 답 증가
        if(same != 0 || diff != 0) {
            answer++;
        }

        return answer;
    }
}

