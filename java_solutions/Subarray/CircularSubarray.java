package java_solutions.Subarray;

public class CircularSubarray {
    
    static public int maxSubarraySumCircular(int[] nums) {
        int totalsSum=0;
        int currmax=0;
        int maxSum=nums[0];
        int minsum=nums[0];
        int currmin=0;
        for(int n:nums){
            currmax=Math.max(currmax+n,n);
            maxSum=Math.max(maxSum,currmax);
            currmin=Math.min(currmin+n,n);
            minsum=Math.min(minsum,currmin);
            totalsSum+=n;
        }
        if(maxSum>0){
            return maxSum;
        }
        return Math.max(maxSum,totalsSum-minsum);
    }
    public static void main(String[] args) {
        int[] nums = {1,-2,3,-2};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
