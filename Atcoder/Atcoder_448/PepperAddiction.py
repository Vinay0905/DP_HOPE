n,m=map(int,input().split())
c=list(map(int,input().split()))
dem=[0]*(m+1)
for _ in range(n):
    a,b=map(int,input().split())
    dem[a]+=b
ans=0
for j in range(1,m+1):
    ans+=min(dem[j],c[j-1])
print(ans)