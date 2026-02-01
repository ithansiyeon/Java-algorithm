package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2022 카카오 인턴십 > 두 큐 합 같게 만들기
 */

public class Algorithm03 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> qq1 = new LinkedList<Integer>();
        Queue<Integer> qq2 = new LinkedList<Integer>();
        long q1Sum = 0;
        long total = 0;
        for (int i=0;i<queue1.length;i++) {
            total += queue1[i] + queue2[i];
            q1Sum += queue1[i];
            qq1.add(queue1[i]);
            qq2.add(queue2[i]);
        }
        if (total % 2 != 0) return -1;

        long target = total / 2;
        while (true) {
            if (answer > (queue1.length + queue2.length)*2) return -1;
            if (q1Sum == target) break;
            else if (q1Sum > target) {
                q1Sum -= qq1.peek();
                qq2.add(qq1.poll());
            } else {
                q1Sum += qq2.peek();
                qq1.add(qq2.poll());
            }
            answer++;
        }
        return answer;
    }

}
