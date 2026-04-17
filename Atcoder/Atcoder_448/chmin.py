n,x=map(int,input().split())
a=list(map(int,input().split()))
for arr in a:
    if arr<x:
        x=arr
        print(1)
    else:        print(0)