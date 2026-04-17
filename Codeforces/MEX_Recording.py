t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    count=[0]*(n+2)
    for x in a:
        count[x]+=1
        
    if count[0]==0:
        print("NO")
    
    elif count[0]==1:
        print("YES")
    else:
        if count[1]==0:
            print("NO")
        else:
            print("YES")