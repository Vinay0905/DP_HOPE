t=int(input())
for _ in range(t):
    a,b,x,y=map(int,input().split())
    k=a//x
    tots=(a-k*x)+(b+k*y)
    print(tots)