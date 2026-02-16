package BaekJoon;

import java.util.*;

/**
 * 연결 요소의 개수
 * 시간, 공간 복잡도 (n+m)
 */
public class Dfs001 {

	static boolean[] visited;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(), m = kb.nextInt();
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int a = kb.nextInt(), b = kb.nextInt();
			graph[a - 1].add(b - 1);
			graph[b - 1].add(a - 1);
		}
		visited = new boolean[n];
		solution(n);
	}

	public static void solution(int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}

	public static void dfs(int node) {
		visited[node] = true;

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}
