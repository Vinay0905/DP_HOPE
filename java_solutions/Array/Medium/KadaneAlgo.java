package java_solutions.Array.Medium;
import java.util.Arrays;

public class KadaneAlgo {
    // Tries every subarray and recalculates its sum using a third loop.
    // The maximum sum among all these subarrays is stored as the answer.
    public static int bruteForce(int[] nums){
        int maxL=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum=0;
                for (int k = i; k <= j; k++) {
                    sum+=nums[k];
                }
                maxL=Math.max(maxL,sum);
                
            }
        }
        return maxL;

    }
    // Fixes the start index and builds the subarray sum while moving the end index.
    // This avoids recomputing the same sum from scratch for every subarray.
    public static int betterSolution(int[] nums){
        // int n=nums.length;
        int maxL=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                
                
                    sum+=nums[j];
                
                
                

                maxL=Math.max(maxL,sum);
                
            }
        }
        return maxL;
    }
    // Kadane's algorithm keeps the best running sum and drops it when it becomes negative.
    // This finds the maximum subarray sum in a single pass.
    public static int optimalSolution(int[] arr){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(sum<0)sum=0;
            sum+=arr[i];
            max=Math.max(max, sum);
            
        }
        return max;
    }
    // Tracks the start and end indices whenever Kadane's running sum creates a better answer.
    // After the scan, it copies and returns the maximum sum subarray.
    public static int[] ReturnTheSubarray(int[] arr){
        int max=Integer.MIN_VALUE;
        int start=0;
        int sum=0;
        int maxstart=-1,maxend=-1;
        for(int i=0;i<arr.length;i++){
            if(sum<0)sum=0;
            if(sum==0)start=i;
            sum+=arr[i];
            
            if(sum>max){
                max=sum;
                maxstart=start;maxend=i;

            }
        }
        int[] subarray=new int[maxend-maxstart+1];
        for(int i=maxstart;i<=maxend;i++){
            subarray[i-maxstart]=arr[i];
        }
        return subarray;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, -2, 7, -4}; 
        int s=bruteForce(nums);
        System.out.println(s);
        System.out.println(betterSolution(nums));
        System.out.println(optimalSolution(nums));
        System.out.println(Arrays.toString(ReturnTheSubarray(nums)));
        
    }
}
