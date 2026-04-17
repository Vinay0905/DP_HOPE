package java_solutions.Binary_search;

public class Search_InsertPosition {

    public static int Search(int[] nums, int t) {
        int n = nums.length;
        int l = 0, h = n - 1;

        int ans = n;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] >= t) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {

        int[] arr = { 1, 3, 5, 6 };
        int x = 5;
        int ind = Search(arr, x);
        System.out.print(ind);
    }
}
