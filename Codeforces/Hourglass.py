import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    s, k, m = map(int, input().split())

    passed = m % k
    fallen = min(passed, s)
    remaining = s - fallen

    print(remaining)

# import sys
# input=sys.stdin.readline
# t=int(input())
# for _ in range(t):
#     s,k,m=map(int,input().split())
#     if m<k:
        
#         fall=m
#         re=s-fall
#     else:
#         lastFlip=(m//k)*k
#         TimeFlip=m-lastFlip
#         if k>=s:
#             fall=min(TimeFlip, s)
#             re=s-fall
#         else:
#             fall=min(TimeFlip,k)
#             re = k-fall
    
#     print(max(0, re))