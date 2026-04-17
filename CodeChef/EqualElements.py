t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    best_st=[-1]*(n+1)
    curr_dp=0
    for x in a:
        cand=-1
        if best_st[x]!=-1:
            cand=best_st[x]+2
        if cand>curr_dp:
            new_dp=cand
        else:
            new_dp=curr_dp
        
        if curr_dp>best_st[x]:
            best_st[x]=curr_dp
        
        curr_dp=new_dp
    print(curr_dp)
    