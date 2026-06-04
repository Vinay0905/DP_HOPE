package SDESheetChallenge_2026.June_3;

public class RotateImage {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Pointer = m - 1;
        int nums2Pointer = n - 1;
        int mergePointer = m + n - 1;

        while (nums1Pointer >= 0 && nums2Pointer >= 0) {
            if (nums1[nums1Pointer] > nums2[nums2Pointer]) {
                nums1[mergePointer] = nums1[nums1Pointer];
                nums1Pointer--;
            } else {
                nums1[mergePointer] = nums2[nums2Pointer];
                nums2Pointer--;
            }
            mergePointer--;
        }

        while (nums2Pointer >= 0) {
            nums1[mergePointer] = nums2[nums2Pointer];
            nums2Pointer--;
            mergePointer--;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);

        // Print the merged array
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }    
}
