n,x=map(int,input().split())
c=list(map(int,input().split()))
mod=10**9+7
dp=[mod]*(x+1)
dp[0]=0
for i in range(1,x+1):
    for j in c:
        if j<=i:
            dp[i]=min(dp[i],dp[i-j]+1)
if dp[x]==mod:
    print(-1)
else:
    print(dp[x])