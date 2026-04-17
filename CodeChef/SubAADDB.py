t=int(input())
for _ in range(t):
    n,a,b =map(int, input().split())
    while n>=a:
        n-=(a-b)
    print(n)
