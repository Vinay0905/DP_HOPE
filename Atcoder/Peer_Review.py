n,m=map(int,input().split())
con=[set() for _ in range(n+1)]
for _ in range(m):
    a,b=map(int,input().split())
    con[a].add(b)
    con[b].add(a)    
tripls=(n-1)*(n-2)*(n-3)//6 if n>=4 else 0
res=[]
for auth in range(1,n+1):
    b=set()
    b.add(auth)
    b.update(con[auth])
    allowed=n-len(b)
    if allowed<3:
        res.append("0")
    else:
        tripls=allowed*(allowed-1)*(allowed-2)//6
        res.append(str(tripls))
print(" ".join(res))
    