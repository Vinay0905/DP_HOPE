t=int(input().strip())
idx=1
res=[]
for _ in range(t):
    n=int(input().strip())
    idx+=1
    s=input().strip()
    idx+=1
    ones=[i for i,ch in enumerate(s) if ch=='1']
    if not ones:
        ans=(n+2)//3
        res.append(str(ans))
        continue
    tots=len(ones)
    pre_len=ones[0]
    tots+=(pre_len+1)//3
    s_len=n-1-ones[-1]
    tots+=(s_len+1)//3
    for i in range(len(ones)-1):
        gap=ones[i+1]-ones[i]- 1 
        if gap>0:
            tots+=gap//3
    res.append(str(tots))
print("\n".join(res))