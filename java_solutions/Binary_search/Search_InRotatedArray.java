package java_solutions.Binary_search;

public class Search_InRotatedArray {
    public static int search(int[] nums, int target, int n) {
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = (h + l) / 2;
            if (nums[m] == target)
                return m;
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
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int x = 0;
        int ind = search(arr, x, arr.length);
        System.out.print(ind);
    }
}
