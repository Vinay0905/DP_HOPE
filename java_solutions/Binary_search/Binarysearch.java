package java_solutions.Binary_search;

public class Binarysearch {
    public static int binsearch(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return -1;

    }

    public static int Binsearch_recursion(int[] nums, int low, int high, int target) {

        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target)
            return Binsearch_recursion(nums, mid + 1, high, target);

        return Binsearch_recursion(nums, low, high - 1, target);

    }

    public static void main(String[] args) {
        int[] a = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 6;
        int ind = binsearch(a, target);
        int nextind = Binsearch_recursion(a, 0, a.length - 1, target);
        if (nextind == -1)
            System.out.println("Element not found");

        else
            System.out.println("Element found at index " + ind);
    }
}
