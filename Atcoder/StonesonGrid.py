import heapq
import sys

data=sys.stdin.read().split
if not data :
    print(-1)
    
    exit()
    
iterator=iter(data)
n=int(next(iterator))
m=int(next(iterator))
ops=[]
for _ in range(m):
    x=int(next(iterator))
    y=int(next(iterator))
    c=int(next(iterator))
    ops.append((x,y,c))
x1,y1,c1=ops[0]
if m==1:
    if x1==y1:
        print(c1)
    else:
        print(-1)
    exit()


graph=[[] for _ in range(n+1)]
for i in range(1,m):
    x,y,c=ops[i]
    graph[y].append((x,c))
INF=10**18
dist=[INF]*(n+1)
dist[x1]=0
heap=[(0, x1)]

while heap:
    d,u=heapq.heappop(heap)
    if d!=dist[u]:
        continue
    if u==y1:
        break
    for v,w in graph[u]:
        nd=d+w
        if nd<dist[v]:
            dist[v]=nd
            heapq.heappush(heap,(nd,v))

if dist[y1]==INF:
    print(-1)
else:
    print(c1 + dist[y1])
    

