package java_solutions.playground;

public class burstballoon {
    
    
    public int maxCoins(int[] nums) {
        int[] arr=new int[nums.length+2];
        arr[0]=arr[arr.length-1]=1;
        for(int i=1;i<=nums.length;i++){
            arr[i]=nums[i-1];

        }
        int[][] dp=new int[arr.length][arr.length];
        for(int i=arr.length-3;i>=0;i--){
            for(int j=i+2;j<arr.length;j++){
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j]);
                }
            }
        }
        return dp[0][arr.length-1];
    }
    public static void main(String[] args) {
        burstballoon sol = new burstballoon();
        int[] nums = {3,1,5,8};
        int result = sol.maxCoins(nums);
        System.out.println("Maximum coins that can be collected: " + result);
    }

}
