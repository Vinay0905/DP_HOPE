t=int(input())
i=3
re=[]
for _ in range(t):
    n,x,k=map(int,input().split())
    i+=3
    min_ch=float('inf')
    for m in range(0,n//k+1):
        y=m*k
        min_ch=min(min_ch,abs(y-x))
    re.append(str(min_ch))
print('\n'.join(re))