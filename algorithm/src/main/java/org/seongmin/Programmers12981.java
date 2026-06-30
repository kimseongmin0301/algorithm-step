package org.seongmin;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 프로그래머스 영어 끝말잇기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 * */

public class Programmers12981 {
    public  static void main(String[] args) {

    }

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        // 맨 첫 단어의 마지막 글자 저장
        char lastChar = words[0].charAt(words[0].length() - 1);

        // 중복 제거를 위해 set 선언
        Set<String> set = new HashSet<>();
        // 첫 단어 삽입
        set.add(words[0]);

        // 두번째 단어부터 시작
        for (int i = 1; i < words.length; i++) {
            set.add(words[i]);
            // 첫번째 글자 저장
            char firstChar = words[i].charAt(0);

            // set 크기가 증가하지 않으면 중복, 끝말잇기가 이어지지 않으면 오답
            if(set.size() != i + 1 || firstChar != lastChar) {

                // 사람, 턴 구하기
                int person = i % n + 1;
                int turn = i / n + 1;

                answer[0] = person;
                answer[1] = turn;
                break;
            }

            // 반복 전 마지막 글자 변경
            lastChar = words[i].charAt(words[i].length() - 1);
        }

        return answer;
    }
}

