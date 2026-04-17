from typing import List
def minCostClimbingStairs(l:List[int]):
    n=len(l)
    dp=[0]*(n+1)
    for i in range(2,n+1):
        dp[i]=min(dp[i-1]+l[i-1],dp[i-2]+l[i-2])
    print(dp[n])
minCostClimbingStairs([10,15,20])
minCostClimbingStairs([1,100,1,1,1,100,1,1,100,1])