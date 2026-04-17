package java_solutions.Binary_search;

public class MinINSortedArary {
    public static int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1, ans = Integer.MAX_VALUE;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[l] <= nums[h]) {
                ans = Math.min(ans, nums[l]);
                l = m + 1;
            } else {
                h = m - 1;
                ans = Math.min(ans, nums[m]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        // Input array
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

        // Call function and store result
        int result = findMin(nums);

        // Output the result
        System.out.println("Minimum element is " + result);
    }
}
