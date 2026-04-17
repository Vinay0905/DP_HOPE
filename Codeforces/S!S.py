n=int(input())
dp=[float('inf')]*(n+1)
dp[0]=0
for i in range(1,n+1):
    if i>=1:
        dp[i]=min(dp[i],dp[i-1]+1)
    if i>=2:
        dp[i]=min(dp[i],dp[i-2]+1)

print(dp[n] if dp[n]!=float('inf') else -1)