t=int(input())
for _ in range(t):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    c=0
    for boss in a:
        for boss2 in b:
            if boss2<boss:
                c+=1
    print(c)