t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    total = sum(a)
    min_diff = min(a[i] - b[i] for i in range(n))
    print(total - min_diff)