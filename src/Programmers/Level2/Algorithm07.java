package Programmers.Level2;

/**
 *  2022 카카오 블라인드 > k진수에서 소수 개수 구하기
 */

public class Algorithm07 {
    public static int solution(int n, int k) {
        int answer = 0;
        String result = Integer.toString(n, k);
        String[] split = result.split("0");

        for (String s : split) {
            Boolean loop = true;

            if (s.isEmpty()) continue;
            Long num = Long.parseLong(s);

            if (num <= 1) {
                loop = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        loop = false;
                        break;
                    }
                }
            }

            if (loop) answer += 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(110011, 10));
    }
}
