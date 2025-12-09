public class rod_cutting {
    public static void main(String[] args) {
        int n = 4;
        int price[] = { 1, 5, 8, 9 };
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (j < i) {
                    dp[i][j] = dp[i - 1][j];

                } else {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - i], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[n][n]);

    }
}
