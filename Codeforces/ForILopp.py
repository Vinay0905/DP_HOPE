n=int(input())
if n==0:
    print(0)
    exit()
if n==1:
    print(67)
    exit()
a,b=0,67
for i in range(2,n+1):
    if a==0:
        print(-1)
        exit()
    c=b*b(b//a)
    if c>10**18:
        print(-1)
        exit()
    a,b=b,c
print(b)

