
t=int(input())
res=[]
for _ in range(t):
    n=int(input())
    s=input()
    c=0
    has=False
    for i in range(n):
        if s[i]!=s[(i+1)%n]:
            c+=1
        else:
            has=True
    if has:
            res.append(str(c+1))
    else:
        res.append(str(c))
print('\n'.join(res))