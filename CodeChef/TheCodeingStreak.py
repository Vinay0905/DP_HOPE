t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    c=0    
    m=0
    for i in a:
        if i>0:
            c+=1
            if c>m:
                m=c
        else:
            c=0
    print(m)
            
   