package Level2;

/**
 * 그리드 문제
 * 최대 용량 만큼 배달 하면서 이동
 * 다시 빈 트럭 상태 일때 다시 최대 용량 만큼 수거 가능
 */

public class Algorithm01 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d = 0;
        int p = 0;
        for (int i=n-1;i>=0;i--) {
            d-=deliveries[i];
            p-=pickups[i];

            while (d<0 || p<0) {
                d+=cap;
                p+=cap;
                answer += (i+1)*2;
            }
        }
        return answer;
    }
}
