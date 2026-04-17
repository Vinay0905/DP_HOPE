import sys
from bisect import bisect_right
mod=998244353
maqx_n = 200005
pow2=[1] * maqx_n
for i in range(1, maqx_n):
    pow2[i]=(pow2[i-1]*2)%mod
t=int(input())
for _ in range(t):
    n=int(input())
    arr=list(map(int,input().split()))
    nxt=[0]*n
    for i in range(n):
        idx=bisect_right(arr,2*arr[i])
        nxt[i]=idx
    grps=[[]for _ in range(n+1)]
    for i in range(n):
        if nxt[i]<=n:
            grps[nxt[i]].append(i)
    dp=[0]*n
    reun_sum=0
    for i in range(n):
        for u in grps[i]:
            exponent=i-u-1
            term=(dp[u]*pow2[exponent])%mod
            reun_sum=(reun_sum+term)%mod
        dp[i]=(1+reun_sum)%mod
    tots=0
    for i in range(n):
        exponent=n-1-i
        term=(dp[i]*pow2[exponent])%mod
        tots=(tots+term)%mod
    print(tots)