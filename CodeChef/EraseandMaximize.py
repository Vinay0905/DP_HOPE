t=int(input())
for _ in range(t):
    n,s=map(int, input().split())
    min_k=max(0,s-5*n)
    max_s=6*n-min_k
    print(max_s)
    