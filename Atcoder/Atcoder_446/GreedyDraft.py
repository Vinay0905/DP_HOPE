n,m=map(int,input().split())
taken=[False]*(m+1)
ans=[]
for _ in range(n):
    L=int(input())
    
    wish=list(map(int,input().split()))
    choosen=0
    for w in wish:
        if not taken[w]:
            choosen=w
            taken[w]=True
            break
    ans.append(choosen)
print(*ans,sep="\n")