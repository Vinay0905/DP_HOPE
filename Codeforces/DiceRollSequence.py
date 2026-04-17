# import sys
# input = sys.stdin.readline

# def are_adjacent(x, y):
#     if x == y:
#         return False
#     if x + y == 7:
#         return False
#     return True

# t = int(input())
# for _ in range(t):
#     n = int(input())
#     a = list(map(int, input().split()))
    
#     if n == 1:
#         print(0)
#         continue
    
#     dp = [[float('inf')] * 7 for _ in range(n)]
    
#     for val in range(1, 7):
#         dp[0][val] = 0 if a[0] == val else 1
    
#     for i in range(1, n):
#         for curr in range(1, 7):
#             cost_curr = 0 if a[i] == curr else 1
#             for prev in range(1, 7):
#                 if are_adjacent(prev, curr):
#                     dp[i][curr] = min(dp[i][curr], dp[i-1][prev] + cost_curr)
    
#     print(min(dp[n-1][1:]))

y=int(input())
res=[]
adj=[[u for u in range(1,7)if u!=v and u!=7-v] for v in range(7)]
for _ in range(y):
    n=int(input())
    a=list(map(int,input().split()))
    dp=[0]*7
    for v in range(1,7):
        dp[v]=0 if a[0]==v else 1
    for i in range(1,n):
        ndp=[10**9]*7
        for v in range(1,7):
            cost=0 if a[i]==v else 1
            best=min(dp[u] for u in adj[v])
            ndp[v]=best+cost
        dp=ndp
    res.append(str(min(dp[1:])))
print("\n".join(res))