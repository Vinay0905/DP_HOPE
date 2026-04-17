t=int(input())

res=[]
for _ in range(t):
    n,x,y=map(int,input().split())
    a=list(map(int,input().split()))
    t_c=sum(v//x for v in a)
    b=0
    for v in a:
        candi=v+y*(t_c-v//x)
        if candi > b:
            b = candi
    res.append(str(b))

print("\n".join(res))