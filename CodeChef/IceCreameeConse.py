T=int(input())
for _ in range(T):
    x,y,n=map(int,input().split())
    print(max(0, x-y*n))
