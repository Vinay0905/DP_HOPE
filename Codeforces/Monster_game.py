t=int(input().strip())
res=[]
for _ in range(t):
    n=int(input().strip())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    a.sort()
    pref_b=[0]*(n+1)
    for i in range(n):
        pref_b[i+1]=pref_b[i]+b[i]
        
    max_s=0
    sword_u=0
    for k in range(1,n+1):
        sword_n=pref_b[k]
        if sword_n>n:
            break
        x=a[n-sword_n]
        score=x*k
        if score>max_s:
            max_s=score
    res.append(str(max_s))
print('\n'.join(res))