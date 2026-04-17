t=int(input())
for _ in range(t):
    n,s,x=map(int,input().split())
    a=list(map(int,input().split()))
    total=sum(a)
    if total<=s and (s-total)%x==0:
        print("YES")
    else:
        print("NO")