y=int(input())


res=[]

for _ in range(y):
    n=int(input())
    a=list(map(int,input().split()))
    found=False
    for i in range(n):
        if a[i]==67:
            found=True
    res.append("YES" if found else "NO")
print("\n".join(res))