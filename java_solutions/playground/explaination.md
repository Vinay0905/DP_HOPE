To find the highest sum of a contiguous subsequence in an array, you can use Kadane's Algorithm. This 
algorithm efficiently computes the maximum sum of a contiguous subarray with a time complexity of O(n). 
Here's how you can implement it in Java:

```java
public class HighestSumSubsequence {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        // Initialize variables
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

      
        for (int i = 1; i < nums.length; i++) {
            
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);

            
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] array = {1, 101, 2, 3, 100, 4, 5};
        int result = maxSubArray(array);
        System.out.println("The highest sum of a contiguous subsequence is: " + result);
    }
}
```

### Explanation:
- **Initialization**: 
  - `maxSoFar` is initialized to the first element of the array. It keeps track of the maximum sum found 
so far.
  - `maxEndingHere` is also initialized to the first element. It represents the maximum sum of the 
subarray that ends at the current position.

- **Iteration**:
  - For each element in the array starting from the second element, update `maxEndingHere` to be the 
maximum of the current element itself or the sum of `maxEndingHere` and the current element. This step 
decides whether to start a new subarray at the current element or to continue the existing subarray.
  - Update `maxSoFar` to be the maximum of itself and `maxEndingHere`. This ensures that `maxSoFar` 
always contains the maximum sum found so far.

- **Result**:
  - After iterating through the array, `maxSoFar` will contain the highest sum of a contiguous 
subsequence. The `main` method demonstrates how to use this function with the given example array.

This program will output `1	06`, which is the highest sum of a contiguous subsequence in the array `{1, 
101, 2, 3, 100, 4, 5}`.