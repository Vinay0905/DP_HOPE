t=int(input())
i=1
re=[]
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    i+=n
    c=[0]*(n+2)
    for x in a:
        if x==1:
            c[1]+=1
        elif c[x-1]>0:
            c[x]+=1
            
    re.append(str(sum(c)))
print('\n'.join(re ))