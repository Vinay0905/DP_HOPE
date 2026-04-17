import sys
mod=10**9+7
d=sys.stdin.read().split()
t=int(d[0])
idx=1
res=[]

for _ in range(t):
    n=int(d[idx]);idx+=1
    Ax=int(d[idx]);Ay=int(d[idx+1]);Bx=int(d[idx+2]);By=int(d[idx+3])
    idx+=4
    xs=list(map(int,d[idx:idx+n]));idx+=n
    ys=list(map(int,d[idx:idx+n]));idx+=n
    t_x=Bx-Ax
    min_y=min(ys)
    max_y=max(ys)
    ex_y=0
    if Ay<min_y:
        ex_y+=min_y-Ay
    elif Ay>max_y:
        ex_y+=Ay-max_y
    
    if By<min_y:
        ex_y+=min_y-By
    elif By>max_y:
        ex_y+=By-max_y
    ans=t_x+ex_y
    res.append(str(ans%mod))
sys.stdout.write("\n".join(res))


    