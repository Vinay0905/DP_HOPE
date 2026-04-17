n,k=map(int,input().split())
l,h=0,2*10**9
while l<h:
    m=(l+h)//2
    t=(m+1)*n+m*(m+1)//2
    if t>=k:
        h=m
    else:
        l=m+1
print(l)        
