package java_solutions.Binary_search;

public class Find_PEAAK {

    public static int findpeak(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1])
                return nums[m];
            else if (nums[m] > nums[m - 1]) {
                l = m + 1;
            } else {
                h = m - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 1 };
        int ind = findpeak(arr);
        System.out.print(ind);
    }
}
