package Level2;

import java.util.Arrays;

public class algorithm05 {
    static int[] answer = {};
    static int max = Integer.MIN_VALUE;
    static int[] lionArr = new int[11];
    public int[] solution(int n, int[] info) {
        dfs(0,n,info);
        if (answer.length == 0) return new int[]{-1};
        else return answer;
    }

    public static void dfs(int depth, int n, int[] info) {
        if (depth == n) {
            int apeachSum = 0;
            int lionSum = 0;
            for (int i = 0; i < 11; i++) {
                if (info[i] == 0 && lionArr[i] == 0) continue;
                if (lionArr[i] > info[i]) {
                    lionSum += (10 - i);
                } else {
                    apeachSum += (10 - i);
                }
            }
            if (max <= (lionSum - apeachSum) && lionSum > apeachSum) {
                max = lionSum - apeachSum;
                answer = lionArr.clone();
            }
            return;
        }
        for (int i = 0; i < 11 && lionArr[i] <= info[i]; i++) {
            lionArr[i]++;
            dfs(depth+1,n,info);
            lionArr[i]--;
        }
    }

    public static void main(String[] args) {
        algorithm05 solution = new algorithm05();
        int[] result = solution.solution(9, new int[] {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1});
        System.out.println(Arrays.toString(result));
    }
}
