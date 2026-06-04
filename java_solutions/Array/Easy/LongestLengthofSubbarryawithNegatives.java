package java_solutions.Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestLengthofSubbarryawithNegatives {
    // Checks every possible subarray by fixing a start index and extending the end index.
    // The running sum is compared with targ to keep the maximum valid length.
    public static int bruteforce(int[] arr,int targ){
        // Stores the length of the longest subarray found with sum equal to targ.
        int max=0;

        // Pick every possible starting index for the subarray.
        for(int i=0;i<arr.length;i++){
            // Stores the sum of the subarray starting from index i.
            int sum=0;

            // Extend the subarray from index i to every possible ending index j.
            for(int j=i;j<arr.length;j++){
                // Add the current element to the running subarray sum.
                sum+=arr[j];

                // If this subarray's sum matches targ, update max with its length.
                if(sum==targ){
                    max=Math.max(max,j-i+1);
                }
            }
        }

        // Return the longest length found.
        return max;
    }

    // Uses prefix sum with a HashMap storing the first index of each prefix sum.
    // If sum - targ was seen before, the subarray between those indices has the target sum.
    public static int optimalSolu(int[] arr,int targ){
        // Stores the sum of elements traversed so far.
        int sum=0;
        // Stores the length of the longest subarray found with sum equal to targ.
        int max=0;
        // Stores prefix sum as key and the first index where that prefix sum appeared as value.
        Map<Integer,Integer> map=new HashMap<>();

        // Traverse the array from left to right.
        for(int i=0;i<arr.length;i++){
            // Add the current array element to the prefix sum.
            sum+=arr[i];
            int rem=sum-targ;
            // If sum equals targ, subarray from index 0 to i has the required sum.
            if(sum==targ){
                max=Math.max(max,i+1);
            }
            
            
            // Check whether the required previous prefix sum already exists in the HashMap.
            else if(map.containsKey(rem)){
                // If it exists, the subarray after that index up to i has sum equal to targ.
                int len=i-map.get(rem);
                max=Math.max(max,len);
            }

            // Store this prefix sum only if it was not seen before, to keep the longest length.
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }

        // Return the longest length found after traversing the entire array.
        return max;
    }

    public static void main(String[] args) {
        int array[] = {9, -3, 3, -1, 6, -5}  ;
        System.out.println(bruteforce(array, 0));
        System.out.println(optimalSolu(array,0));
    }
}
