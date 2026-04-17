public class triangle {
    public static void main(String[] args) {
        int triangle[][] = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
        int n = triangle.length;
        int dp[] = new int[n];
        int k = 0;
        for (int i : triangle[n - 1]) {
            dp[k++] = i;

        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle[i][j] + Math.min(dp[j], dp[j + 1]);

            }

        }
        // for (int i : dp) {
        // System.out.println(i);
        // }
        System.out.println(dp[0]);
    }
}
