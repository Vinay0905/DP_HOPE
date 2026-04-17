t=int(input())
for _ in range(t):
    n=int(input())
    arr=list(map(int,input().split()))
    cost=0
    for i in range(n-1,-1,-1):
        if arr[i]!=i+1:
            cost+=arr[i]
            arr[:i+1]=sorted(arr[:i+1])
    print(cost)

    