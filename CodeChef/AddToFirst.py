t=int(input())
i=1
re=[]
for _ in range(t):
    n=int(input())
    i+=1
    a=list(map(int,input().split()))
    i+=n
    b=list(map(int,input().split()))
    i+=n
    p_max=0
    poss=True
    for i in range(n):
        if b[i]<a[i]:
            poss=False
            break
        if b[i]>a[i] and a[i]<=p_max:
            poss=False
            break
        if a[i]>p_max:
            p_max=a[i]
    re.append("Yes" if poss else "No")

print('\n'.join(re))