t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))

    pos=[0]*(n+1)
    for i in range(n):
        pos[a[i]]=i
    
    valid=True
    for i in range(n-1):
        if (pos[i+1]%2) ==  (pos[i+2]%2):
            valid=False
            break
    if valid:
        print("YES")
    else:
        print("NO")

