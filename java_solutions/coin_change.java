public class coin_change {
    public static void main(String[] args) {
        int coins[] = { 1, 2, 5 };
        int amount = 11;
        int n = coins.length;

        int dp[][] = new int[n + 1][amount + 1];

        for (int r = 0; r < n + 1; r++) {
            dp[0][r] = 0;
        }
        dp[0][0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i - 1])
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[n][amount]);

    }
}