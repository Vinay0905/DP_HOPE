package java_solutions.Array.Hard;

import java.util.HashMap;

public class largestSubaaryaWithZeroSum {
    
    public static int bruteforce(int[] arr) {
        int n = arr.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == 0) {
                    maxLength = Math.max(maxLength, j - i + 1);
                    printSubarray(arr, i, j);
                }
            }
        }

        return maxLength;
    }

    public static int optimal(int[] arr) {
        HashMap<Integer, Integer> firstSeenIndex = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            if (firstSeenIndex.containsKey(prefixSum)) {
                int length = i - firstSeenIndex.get(prefixSum);
                maxLength = Math.max(maxLength, length);
            } else {
                firstSeenIndex.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    private static void printSubarray(int[] arr, int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);
            if (i < end) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = {9, -3, 3, -1, 6, -5};  

        System.out.println("Zero sum subarrays:");
        int bruteForceAnswer = bruteforce(arr);

        System.out.println("Largest zero sum subarray length using brute force: " + bruteForceAnswer);
        System.out.println("Largest zero sum subarray length using optimal: " + optimal(arr));
    }
}
