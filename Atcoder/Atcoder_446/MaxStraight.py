n=int(input())
a=list(map(int,input().split()))
dp={}
ans=0
for x  in a:
    dp[x]=dp.get(x-1,0)+1
    if dp[x]>ans:
        ans=dp[x]
print(ans)