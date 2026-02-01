package BaekJoon;

import java.util.Scanner;

/**
 * 설탕 배달
 */

public class Greedy001 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int cnt = Integer.MAX_VALUE;
		for (int i = 0; i <= n / 3; i++) {
			if ((n - i * 3) % 5 != 0) continue;
			cnt = Math.min(cnt, i + (n - i * 3) / 5);
		}
		if (cnt == Integer.MAX_VALUE) return -1;
		else return cnt;
	}
}
