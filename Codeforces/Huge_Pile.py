import sys
from collections import deque

input=sys.stdin.readline

t=int(input())
for _ in range(t):
    n,k=map(int,input().split())
    if k>n:
        print(-1)
        continue
    if k==n:
        print(0)
        continue
    q=deque([(n,0)])
    visit=set([n])
    found=False
    while q:
        curr,steps=q.popleft()
        l=curr//2
        r=(curr+1)//2
        
        if l==k or r==k:
            print(steps+1)
            found=True
            break
        if l>0 and l not in visit:
            visit.add(l)
            q.append((l,steps+1))
            
        if r>0 and r not in visit:
            visit.add(r)
            q.append((r,steps+1))
    if not found:
        print(-1)