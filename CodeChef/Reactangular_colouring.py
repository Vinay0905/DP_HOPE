import sys

input=sys.stdin.readline
t=int(input())
for _ in range(t):
    l,w,r,g,bl=map(int, input().split())
    a = max(l,w)
    b = min(l,w)
    
    pai=[r,g,bl]
    pai.sort()
    option1=sorted([2*a,b,b])
    option2=sorted([2*b,a,a])
    option3=sorted([a+b,a,b])
    if pai==option1 or pai==option2 or pai==option3:
        print(4)
    else:
        mx=max(r,g,bl)
        small=r+g+bl-mx
        if small<b:
            print(6)
        else:
            print(5)