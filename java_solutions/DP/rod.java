package java_solutions.DP;

public class rod {

    public static int cutrod(int[] arr,int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int hig=Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                hig=Math.max(hig,dp[i-j-1]+arr[j]);
                
            }
            dp[i]=hig;

        }
        return dp[n];

    }
    public static void main(String[] args) {
        int n=8;
        int arr[]={1,5,8,9,10,17,17,20};
        System.out.println(cutrod(arr, n));
    }
}
