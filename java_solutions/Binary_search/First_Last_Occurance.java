package java_solutions.Binary_search;

public class First_Last_Occurance {
    public static int First_Occurance(int[] nums, int n, int k) {
        int l = 0, h = n - 1;
        int first = -1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == k) {
                first = m;
                h = m - 1;
            } else if (nums[m] < k)
                l = m + 1;
            else
                h = m - 1;
        }
        return first;
    }

    public static int Last_Occurance(int[] nums, int n, int k) {
        int l = 0, h = n - 1;
        int last = -1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == k) {
                last = m;
                l = m + 1;
            } else if (nums[m] < k)
                l = m + 1;
            else
                h = m - 1;
        }
        return last;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };
        int x = 2;
        int ind = First_Occurance(arr, arr.length, x);
        int ind2 = Last_Occurance(arr, arr.length, x);
        System.out.print(ind + " " + ind2);
    }
}
