import sys
input=sys.stdin.readline
t=int(input())
for _ in range(t):
    n=int(input())
    p=list(map(int,input().split()))
    diffs=[]
    for i in range(n-1):
        diffs.append(abs(p[i]-p[i+1]))
    m=len(diffs)
    if m==0:
        continue
    leftB=[-1]*m
    s=[]
    for i in range(m):
        while s and diffs[s[-1]]>=diffs[i]:
            s.pop()
        if s:
            leftB[i]=s[-1]
        s.append(i)
    right_bound=[m]*m
    s=[]
    for i in range(m-1,-1,-1):
        while s and diffs[s[-1]]>diffs[i]:
            s.pop()
        if s:
            right_bound[i]=s[-1]
        s.append(i)
    max_val=max(diffs)
    min_count=[0]*(max_val+2)
    for i in range(m):
    
        lc=i-leftB[i]
        rc=right_bound[i]-i
        ts=lc*rc
        min_count[diffs[i]]+=ts
    ans=[0]* (n+1)
    curtes=0
    for k in range(max_val,0,-1):
        curtes+=min_count[k]
        ans[k]=curtes
    output=[]
    for k in range(1,n):
        output.append(str(ans[k]))
    print(' '.join(output))

