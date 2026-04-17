package java_solutions.DP;

public class knapsack {


    
    public static int Knapsack(int W, int val[], int wt[]) {
        int n=val.length;
        int[] dp=new int[W+1];
        for (int i=0;i<n;i++) {
            for (int w=wt[i];w<=W;w++) {
                dp[w]=Math.max(dp[w],dp[w-wt[i]]+val[i]);
            }
        }
        return dp[W];
    }
 
    public static void main(String[] args) {
        int[] wt={5,4,2,3};
        int[] val={10,40,30,50};
        int w=5;
        System.out.println(Knapsack(w, val, wt));
    }
}
