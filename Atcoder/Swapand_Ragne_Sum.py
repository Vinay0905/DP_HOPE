n,q=map(int,input().split())
a=list(map(int,input().split()))
s=n
freq=[0]*(s+1)
def add(i,d):
    i1=i+1
    while i1<=s:
        freq[i1]+=d
        i1+=i1&-i1
def pre_sum(i):
    r=0
    i1=i+1
    while i1>0:
        r+=freq[i1]
        i1-=i1&-i1
    return r
def range_s(l,r):
    if l==0:
        return pre_sum(r)
    else:
        return pre_sum(r)-pre_sum(l-1)
for z in range(n):
    add(z,a[z])
out=[]
for _ in range(q):
    q=list(map(int,input().split()))
    if q[0]==1:
        x=q[1]-1
        add(x,a[x+1]-a[x])
        add(x+1,a[x]-a[x+1])
        a[x],a[x+1]=a[x+1],a[x]
    else:
        l=q[1]-1
        r=q[2]-1
        out.append(str(range_s(l,r)))
print("\n".join(out))
