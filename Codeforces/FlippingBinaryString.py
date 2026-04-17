t = int(input())
out=[]

for _ in range(t):
    n=int(input())
    s=input()
    on=[]
    ze=[]
    for i, c in enumerate(s):
        if c=='1':
            on.append(i+1)
        else:
            ze.append(i+1)
    
    if len(ze)%2==1:
        out.append(str(len(ze)))
        out.append(" ".join(map(str, ze)))
    elif len(on)%2==0:
        out.append(str(len(on)))
        out.append(" ".join(map(str, on)))
    else:
        out.append("-1")

print("\n".join(out))