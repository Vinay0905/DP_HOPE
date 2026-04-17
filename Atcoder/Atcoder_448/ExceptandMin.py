n,q=map(int,input().split())
a=list(map(int,input().split()))

idx=sorted([(a[i],i+1) for i in range(n)])

res=[]
for _ in range(q):
    k=int(input())
    rem=list(map(int,input().split()))
    for i in range(k+1):
        val,inx=idx[i]
        if inx not in rem:
            res.append(str(val))
            break
print('\n'.join(res))