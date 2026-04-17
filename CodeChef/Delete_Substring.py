t=int(input())
i=1
re=[]
inf=10**9
for _ in range(t):
    n,m=map(int,input().split())
    i+=2
    s=input().strip()
    i+=1
    t=input().strip()
    i+=1
    if m>n:
        re.append("-1")
        continue
    dp=[inf]*n
    first_c=t[0]
    for i,ch in enumerate(s):
        if ch==first_c:
            dp[i]=1 if i>0 else 0
    for pos in range(1,m):
        ch_n=t[pos]
        dp_c=[inf]*n
        min_bef=inf
        for j in range(n):
            if s[j]==ch_n:
                cand=dp[j-1]if j>0 else inf
                cand_gap=1+min_bef if min_bef!=inf else inf
                dp_c[j]=cand if cand<cand_gap else cand_gap
            if j>0 and dp[j-1]<min_bef:
                min_bef=dp[j-1]
        dp=dp_c
    best=inf
    for i in range(n):
        if dp[i]<inf:
            total=dp[i]+(1 if i<n-1 else 0)
            if total<best:
                best=total
    re.append(str(best) if best!=inf else "-1")
print('\n'.join(re))