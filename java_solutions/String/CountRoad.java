package java_solutions.String;

public class CountRoad {
    static int MOD=1000000007;
    static Integer[][]  dp;
    
    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n=locations.length;
        dp=new Integer[n][fuel+1];
        return dfs(locations, start, finish, fuel);
    }
    public static int dfs(int[] loc,int i, int finish,int fuel){
        if(fuel<0)return 0;
        if(dp[i][fuel]!=null)return dp[i][fuel];
        int ans=0;
        if(i==finish)ans=1;
        for(int j=0;j<loc.length;j++){
            if(i!=j){
                int cost=Math.abs(loc[i]-loc[j]);
                ans=(ans+dfs(loc, j, finish, fuel-cost))%MOD;
            }
        }
        return dp[i][fuel] = ans;

    }
    public static void main(String[] args) {
        
        int[] loc={2,3,6,8,4};
        int start=1;
        int finish=3;
        int fuel=5;
        System.out.println(countRoutes(loc, start, finish, fuel));
    }
}
