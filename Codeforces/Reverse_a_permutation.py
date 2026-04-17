t=int(input())
for _ in range(t):
    n=int(input())
    p=list(map(int,input().split()))
    i=0
    while i<n and p[i]==n-i:
        i+=1
    if i<n:
        tar=n-i
        j=p.index(tar,i)
        p[i:j+1]=p[i:j+1][::-1]
        
    print(' '.join(map(str,p)))
    