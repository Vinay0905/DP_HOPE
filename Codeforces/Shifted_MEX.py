t=int(input().strip())
for _ in range(t):
    n=int(input().strip())
    a=list(map(int,input().split()))
    uniq=sorted(set(a))
    l=0
    c=0
    for i in range(len(uniq)):
        if i==0 or uniq[i]!=uniq[i-1]+1:
            c=1
        else:
            c+=1
        l=max(l,c)
    print(l)