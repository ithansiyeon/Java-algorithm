package Programmers.Level2;

/**
 * 2023 카카오 블라인드 채용 > 이모티콘 할인행사
 */

public class Algorithm02 {
    static int[] discount = {10, 20, 30, 40};
    static int maxOfSubscribe;
    static int maxOfCost;
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, users, new int[emoticons.length], emoticons);
        return new int[] {maxOfSubscribe, maxOfCost};
    }

    public void dfs(int depth, int[][] users, int[] discounts, int[] emoticons) {
        if (depth == emoticons.length) {
            int subscibe = 0;
            int cost = 0;
            for (int[] user : users) {
                int userPercent = user[0];
                int userCost = user[1];
                int sum = 0;
                for (int i = 0; i < emoticons.length; i++) {
                    if (discounts[i] >= userPercent) sum += emoticons[i] / 100 * (100-discounts[i]);
                }
                if (sum >= userCost) subscibe++;
                else cost += sum;
            }
            if (subscibe > maxOfSubscribe) {
                maxOfSubscribe = subscibe;
                maxOfCost = cost;
            } else if (subscibe == maxOfSubscribe) {
                maxOfCost = Math.max(maxOfCost, cost);
            }
            return;
        }
        for (int i=0;i<4;i++) {
            discounts[depth] = discount[i];
            dfs(depth+1,users,discounts,emoticons);
        }
    }
}
