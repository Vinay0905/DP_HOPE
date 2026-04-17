package java_solutions.playground;

public class highestSumSubsequence {
    
    public static int[] maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        
        int[] dp = new int[nums.length];
        
        int n=nums.length;
        for(int i=0;i<n;i++){
            dp[i]=nums[i];
        }
        

        for (int i = 1; i < nums.length; i++) {
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])dp[i] = Math.max(dp[i], dp[j] + nums[i]);    
            }
            
        }


        
        int maxSum=dp[0];
        for (int num : dp) {
            if (num > maxSum) {
                maxSum = num;
            }
        }

        return dp;
    }



    public static void main(String[] args) {
        int[] array = {1, 101, 2, 3, 100, 4, 5};
        int[] result = maxSubArray(array);
        // System.out.println("The highest sum of a contiguous subsequence is: " + result);
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
        int m=array[0];
        for(int i:result){
            m=Math.max(m,i);
        }
        System.out.println(m);
    }
}

