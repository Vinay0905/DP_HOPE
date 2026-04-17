t=int(input())
lines=[]
for _ in range(t):
    n,q=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    c=[0]*n
    c[-1]=b[-1]
    for i in range(n-2,-1,-1):
        c[i]=max(b[i],c[i+1])
    pre=[0]*(n+1)
    for i in range(n):
        pre[i+1]=pre[i]+c[i]
    res=[]
    for _ in range(q):
        l,r=map(int,input().split())
        tots=pre[r]-pre[l-1]
        res.append(str(tots))
    lines.append(' '.join(res))
print('\n'.join(lines))
    
        
           
