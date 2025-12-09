public class unique_path2 {
    public static void main(String[] args) {
        int arr[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int m = arr.length, n = arr[0].length;
        if (arr[0][0] == 1) {
            System.out.println(0);
            return;
        }
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        for (int j = 1; j < n; j++) {
            if (arr[0][j] == 0 && dp[0][j - 1] == 1)
                dp[0][j] = 1;
            else
                dp[0][j] = 0;
        }

        for (int i = 1; i < m; i++) {
            if (arr[i][0] == 0 && dp[i - 1][0] == 1)
                dp[i][0] = 1;
            else
                dp[i][0] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }

        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
