import sys
input=sys.stdin.read
d=input().split()
idx=0
t=int(d[idx])
idx+=1
out=[]
for _ in range(t):
    n=int(d[idx])
    idx+=1
    a=[]
    for i in range(n):
        a.append(int(d[idx]))
        idx+=1
    uniq=set(a)
    fien=float('inf')
    D_array=[fien]*(n+1)
    D_array[1]=0
    for x in uniq:
        for i in range(x,n+1,x):
            if D_array[i//x]!=fien:
                D_array[i]=min(D_array[i],D_array[i//x]+1)
    res=[]
    for i in range(1,n+1):
        if i==1:
            res.append("1" if 1 in uniq else"-1")
        else:
            res.append(str(D_array[i])if D_array[i]!=fien else "-1")
    out.append(" ".join(res))
sys.stdout.write("\n".join(out))

