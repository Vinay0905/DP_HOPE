t=int(input())
res=[]
for _ in range(t):
    n,k=map(int,input().split())
    p=list(map(int,input().split()))
    last=-1
    c=0
    seg_mi=10**18
    seg_ma=-10**18
    for j in range(n):
        c_t=False
        if j>last+1:
            if seg_mi<p[j]-k or seg_ma>p[j]+k:
                c_t=True
        
        if c_t:
            c+=1
            last=j
            seg_mi=10**18
            seg_ma=-10**18
        else:
            if p[j]<seg_mi:
                seg_mi=p[j]
            if p[j]>seg_ma:
                seg_ma=p[j]
    res.append(str(c))
print('\n'.join(res))

    