package java_solutions.playground;

import java.util.Arrays;

public class minimumDestination {
    public static void main(String[] args) {
        int maxTime = 30;
        // int[][] edges = {{0,1,10},{0,2,15},{1,2,10},{1,3,15},{2,3,10}};
        int[][] edges = {{0,1,10},{1,2,10},{2,5,10},{0,3,1},{3,4,10},{4,5,15}};
        int[] fee = {5,1,2,20,20,3};
        minimumDestination sol = new minimumDestination();
        int result = sol.MinCost(maxTime, edges, fee);
        System.out.println("Minimum cost to reach destination: " + result);
    }
    public int MinCost(int mT, int[][] edges, int[] fee) {
        int n = fee.length, mC = Integer.MAX_VALUE;
        int[][] dp = new int [mT+1][n];
        for(int[] row: dp)  Arrays.fill(row, Integer.MAX_VALUE);    
        dp[0][0] = fee[0];      
        
        for(int crr = 0; crr<=mT; crr++){
            for(int[] edge: edges){
                int r_ti = crr+edge[2];
                for(int i=0;r_ti<=mT && i<=1;i++){    
                    int fromNode = edge[i^0], toNode = edge[i^1];    
                    if(dp[crr][fromNode]!=Integer.MAX_VALUE && r_ti<=mT){
                        dp[r_ti][toNode] = Math.min(dp[r_ti][toNode], dp[crr][fromNode]+fee[toNode]);
                    }      
                } 
            } 
        }
        for(int t=0;t<=mT; t++)    mC = Math.min(mC, dp[t][n-1]);
        return mC==Integer.MAX_VALUE? -1 : mC;
    }
}
