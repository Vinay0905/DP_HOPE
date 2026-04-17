t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    o_c=sum(1 for x in a if x%2!=0)
    
    if o_c%2==0:
        print("YES")
    else:
        print("NO")