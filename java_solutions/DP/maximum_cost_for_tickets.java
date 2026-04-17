
public class maximum_cost_for_tickets {
    public static void main(String[] args) {
        int days[] = { 1, 4, 6, 7, 8, 20 };
        int costs[] = { 2, 7, 15 };

        int n = days[days.length - 1];
        int dp[] = new int[n + 1];

        dp[0] = 0;
        int j = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i != days[j]) {
                dp[i] = dp[i - 1];
            } else {
                j += 1;
                int day = dp[i - 1] + costs[0];
                int week = dp[Math.max(0, i - 7)] + costs[1];
                int month = dp[Math.max(0, i - 30)] + costs[2];
                int proxy = Math.min(day, week);
                dp[i] = Math.min(proxy, month);

            }
        }
        System.out.println(dp[n]);

    }
}
