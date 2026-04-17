t=int(input())
idx=1
o_l=[]
for _ in range(t):
    n=int(input())
    idx+=1
    l,r=1,n
    res=[0]*n
    for i in range(n-1,-1,-1):
        if(n-1-i)%2==0:
            res[i]=r
            r-=1
        else:
            res[i]=l
            l+=1
    o_l.append(" ".join(map(str,res)))
print("\n".join(o_l))

