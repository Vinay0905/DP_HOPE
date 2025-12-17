public class ninja_training {
    public static void main(String[] args) {
        int points[][] = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
        int n = points.length;
        int dp[][] = new int[n][3];
        for (int j = 0; j < 3; j++) {
            dp[0][j] = points[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int max_prev = 0;
                for (int k = 0; k < 3; k++) {
                    if (k != j)
                        max_prev = Math.max(max_prev, dp[i - 1][k]);

                }
                dp[i][j] = points[i][j] + max_prev;
            }
        }
        System.out.println(Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2])));
    }
}
