package java_solutions.DP;

public class fib {
    int fibonachi(int n){
        if(n<=1)return n;
        return fibonachi(n-1)+fibonachi(n-2);
    }
    public int tabulation_Fib(int n){
        if(n<=1)return n;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        fib sol=new fib();
        System.out.println(sol.fibonachi(10));
        System.out.println(sol.tabulation_Fib(10));
    }

}
