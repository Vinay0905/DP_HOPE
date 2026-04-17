from math import gcd, atan2, pi
from collections import defaultdict

n,q=map(int,input().split())
p=[tuple(map(int,input().split()))for _ in range(n)]

def normalize(x, y):
    if x==0:
        return(0,1 if y>0 else -1)
    if y==0:
        return(1 if x>0 else -1, 0)
    g=gcd(abs(x),abs(y))
    return (x//g,y//g)

dire=[normalize(x,y)for x,y in p]
Uni=list(set(dire))

Dir_angel={}
for d in Uni:
    angle=atan2(d[1],d[0])
    if angle<0:
        angle+=2*pi
    Dir_angel[d]=angle

sort=sorted(Uni,key=lambda d: Dir_angel[d])
Dir_Ind={d:i for i,d in enumerate(sort)}

C_per=defaultdict(int)
for d in dire:
    C_per[d]+=1

m=len(sort)
counts=[C_per[d] for d in sort]
prefix=[0]*(m+1)
for i in range(m):
    prefix[i+1]=prefix[i]+counts[i]
total=prefix[m]

out_lines=[]
for _ in range(q):
    a,b=map(int, input().split())
    a-=1
    b-=1
    da,db=dire[a],dire[b]
    
    if da==db:
        out_lines.append(str(C_per[da]))
        continue
    
    ia,ib=Dir_Ind[da],Dir_Ind[db]
    a_a,a_b=Dir_angel[da],Dir_angel[db]
    
    if a_a>a_b:
        
        res=prefix[ia+1]-prefix[ib]
    else:
        res=prefix[ia+1]+(total-prefix[ib])
    out_lines.append(str(res))

print("\n".join(out_lines))

