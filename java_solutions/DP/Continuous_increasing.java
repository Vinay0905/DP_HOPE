package java_solutions.DP;

public class Continuous_increasing {
    
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        int max_len=1;
        
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
            else{
                dp[i]=1;
            }
            max_len=Math.max(max_len, dp[i]);
        }
        return max_len;


    }
    public static void main(String[] args) {
        Continuous_increasing ci=new Continuous_increasing();
        int[] nums={1,3,5,4,7};
        System.out.println(ci.findLengthOfLCIS(nums));
    }
}
