from collections import defaultdict

n,m,l,s,t=map(int,input().split())
adj=[[]for _ in range(n+1)]

for _ in range(m):
    u,v,c=map(int,input().split())
    adj[u].append((v,c))
    
cuur_dp=defaultdict(int)
cuur_dp[1]=[(0,0)]    
for _ in range(l):
    next_dp=defaultdict(list)
    for curVer,inter in cuur_dp.items():
        for nextVer,cost in adj[curVer]:
            for low,high in inter:
                new_l=low+cost
                new_h=high+cost
                if new_l<=t:
                    next_dp[nextVer].append((new_l,min(new_h,t)))
    cuur_dp.clear()
    
    for ver,intervals in next_dp.items():
        intervals.sort()
        merged=[]
        for low,high in intervals:
            if not merged or merged[-1][1]<low-1:
                merged.append([low,high])
            else:
                merged[-1][1]=max(merged[-1][1],high)
        cuur_dp[ver]=[(low,high) for low,high in merged]

ans=[]
for ver in range(1,n+1):
    for low,high in cuur_dp.get(ver,[]):
        if not (high<s or low >t):
            ans.append(ver)
            break
print(" ".join(map(str, ans)))


            

