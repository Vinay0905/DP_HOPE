package java_solutions.Binary_search;

public class Lower_bound {
    public static int lower_bound(int[] nums, int target, int n) {
        int l = 0, h = n - 1;

        int ans = n;

        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] >= target) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 1, 2, 2, 3 };
        int x = 2;
        int ind = lower_bound(arr, x, n);
        System.out.print(ind);

    }
}
