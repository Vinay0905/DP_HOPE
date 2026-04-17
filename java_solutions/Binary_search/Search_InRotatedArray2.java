package java_solutions.Binary_search;

public class Search_InRotatedArray2 {
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = (h + l) / 2;

            if (nums[m] == target)
                return true;
            if (nums[l] == nums[m] && nums[m] == nums[h]) {
                l++;
                h--;
                continue;
            }
            if (nums[l] <= nums[m]) {
                if (target >= nums[l] && target <= nums[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }

            } else {
                if (target >= nums[m] && target <= nums[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 };
        int k = 3;

        boolean ans = search(arr, k);

        if (ans)
            System.out.println("Target is present in the array.");
        else
            System.out.println("Target is not present.");
    }
}
