package java_solutions.Binary_search;

import java.util.Arrays;

public class KOKO_EATING_BANNA {

    public static int minEatingSpeed(int[] piles, int k) {
        int n = piles.length;
        int l = 1, h = Arrays.stream(piles).max().getAsInt();
        int ans = Integer.MAX_VALUE;
        while (l <= h) {
            int m = (l + h) / 2;
            int hours = 0;
            for (int i = 0; i < n; i++) {
                hours += Math.ceil((double) piles[i] / m);
            }
            if (hours <= k) {
                ans = Math.min(ans, m);
                h = m - 1;

            } else {
                l = m + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 6, 7, 11 };
        int h = 8;
        int ans = minEatingSpeed(arr, h);
        System.out.print(ans);
    }
}
