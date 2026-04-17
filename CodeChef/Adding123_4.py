t=int(input())
i=1
re=[]
for _ in range(t):
    x,y,z=map(int,input().split())
    i+=3
    pairs=min(x,z)+y//2
    re.append(str(pairs))
print('\n'.join(re))