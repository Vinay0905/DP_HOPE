import java.util.*;

public class counting_bits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 2] + i % 2;
        }
        for (int i = 0; i <= n; i++) {
            System.out.println(dp[i]);
        }
        sc.close();
    }
}
