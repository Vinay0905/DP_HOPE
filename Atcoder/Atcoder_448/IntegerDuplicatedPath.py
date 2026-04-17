import sys
sys.setrecursionlimit(300000)
n=int(input())
a=list(map(int,input().split()))


gra=[[] for _ in range(n)]
for _ in range(n - 1):
    u,v=map(int, input().split())
    gra[u-1].append(v-1)
    gra[v-1].append(u-1)
ans=[""]*n
path={}
def dfs(u,p,dup):
    val=a[u]
    if path.get(val, 0) > 0:
        dup=True
    if dup:
        ans[u]="Yes"
    else:
        ans[u]="No"
    path[val]=path.get(val, 0) + 1
    for v in gra[u]:
        if v != p:
            dfs(v, u, dup)
    path[val]-=1
    if path[val]==0:
        del path[val]
dfs(0,-1,False)
for res in ans:
    print(res)