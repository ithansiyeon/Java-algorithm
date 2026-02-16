package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

/**
 * 미로 탐색
 */

public class Bfs001 {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		kb.nextLine();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = kb.nextLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		bfs(n, m, arr);
	}

	public static void bfs(int n, int m, int[][] arr) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		int distance = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size;  i++) {
				Point point = queue.poll();
				int x = point.x;
				int y = point.y;

				if (x == n -1 && y == m-1) {
					System.out.println(distance);
					return;
				}

				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if (0<=nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new Point(nx, ny));
					}
				}
			}
			distance++;
		}
	}

	public static void bfs2(int n, int m, int[][] arr) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.x, y = point.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i], ny = y + dy[i];
				if (0<= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] == 1) {
					arr[nx][ny] = arr[x][y] + 1;
					queue.add(new Point(nx, ny));
				}
			}
		}
		System.out.println(arr[n-1][m-1]);
	}
}
