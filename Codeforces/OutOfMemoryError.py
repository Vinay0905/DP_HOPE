# t=int(input().strip())
# for _ in range(t):
#     n,m,h=map(int,input().strip().split())
#     a=list(map(int,input().strip().split()))
#     curr_a=a[:]
#     curr_max=max(curr_a)
    
#     for _ in range(m):
#         indx,incr=map(int,input().strip().split())
#         indx-=1
#         N_velue=curr_a[indx]+incr
#         if N_velue>h:
#             curr_a=a[:]
#             curr_max=max(curr_a)
#         else:
#             curr_a[indx]=N_velue
#             if N_velue>curr_max:
#                 curr_max=N_velue
    
#     print(*curr_a)
    
    
t=int(input().strip())
for _ in range(t):
    n,m,h=map(int,input().strip().split())
    a=list(map(int,input().strip().split()))
    added=[0]*n
    curr_max=max(a)
    for _ in range(m):
        indx,incr=map(int,input().strip().split())
        indx-=1
        N_val=a[indx]+added[indx]+incr
        if N_val>h:
            added=[0]*n
            curr_max=max(a)
        else:
            added[indx]+=incr
            if N_val>curr_max:
                curr_max=N_val
    res=[a[i]+added[i] for i in range(n)]
    print(*res)