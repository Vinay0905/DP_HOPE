t=int(input())
res=[]
for _ in range(t):
    n,h,k=map(int,input().split())
    a=list(map(int,input().split()))
    damaga=sum(a)
    max_v=max(a)
    max_i=a.index(max_v)
    pref=[0]*(n+1)
    for i in range(n):
        pref[i+1]=pref[i]+a[i]
    ans=float('inf')
    for bull in range(1,n+1):
        damaga=pref[bull]
        if damaga>=h:
            ans=min(ans,bull)
            continue
        remain=h-damaga
        ful=(remain+damaga-1)
        time=bull+ful*(n+k)
        ans=min(ans,time)
    for i in range(n):
        swap=max_v - a[i]
        if swap <= 0:
            continue
        
        for bulle in range(1, n + 1):
            damage = pref[bulle]
            if i < bulle:
                damage += swap
            
            if damage>=h:
                ans=min(ans, bulle)
                continue
            
            remaining=h-damage
            full_cycles=(remaining + damaga - 1) // damaga
            time=bulle+full_cycles * (n + k)
            ans=min(ans, time)
    res.append(str(ans))
print('\n'.join(res))