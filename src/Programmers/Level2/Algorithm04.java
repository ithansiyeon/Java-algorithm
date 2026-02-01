package Programmers.Level2;

import java.util.*;

/**
 * 2022 카카오 인턴십 > 성격 유형 검사하기
 */

public class Algorithm04 {
    public String solution(String[] survey, int[] choices) {
        Map<Character,Integer> map = new HashMap<>();

        for (int i=0; i< survey.length; i++) {
            char l = survey[i].charAt(0);
            char r = survey[i].charAt(1);
            int value = choices[i];
            if (value == 1) {
                map.put(l, map.getOrDefault(l,0) + 3);
            } else if (value == 2) {
                map.put(l, map.getOrDefault(l,0) + 2);
            } else if (value == 3) {
                map.put(l, map.getOrDefault(l,0) + 1);
            } else if (value == 5) {
                map.put(r, map.getOrDefault(r,0) + 1);
            } else if (value == 6) {
                map.put(r, map.getOrDefault(r,0) + 2);
            } else if (value == 7) {
                map.put(r, map.getOrDefault(r,0) + 3);
            }
        }

        return String.valueOf(
                map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T') +
                (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F') +
                (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M') +
                (map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');
    }
}
