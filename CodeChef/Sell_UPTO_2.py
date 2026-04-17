import heapq as hg
t=int(input())
for _ in range(t):
    n=int(input())
    p=list(map(int,input().split()))
    height=[]
    pr=0
    for i in range(n):
        hg.heappush(height,p[i])
        hg.heappush(height,p[i])
        if len(height)>i+1:
            hg.heappop(height)
    
    print(sum(height))