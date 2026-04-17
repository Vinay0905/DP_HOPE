# # def can_reach(t, j, rb):
# #     td=0
# #     for mj,freq,rc in j:
# #         mu=rb*freq+(freq-1)
# #         d=mu*mj-rb*rc
# #         if d>0:
# #             td+=d
# #         if td>=t:
# #             return True
# #     return False

# # t = int(input())
# # for _ in range(t):
# #     n,x=map(int,input().split())
# #     j=[tuple(map(int,input().split()))for _ in range(n)]
# #     if can_reach(x,j,0):
# #         print(0)
# #         continue
# #     mg=max(a*b-c for a,b,c in j)
# #     if mg<=0:
# #         print(-1)
# #         continue
# #     l,r=1,10**18
# #     answer=-1
# #     while l<=r:
# #         mid=(l+r)//2

# #         if can_reach(x,j,mid):
# #             answer=mid
# #             r=mid-1
# #         else:
# #             l=mid+1

# #     print(answer)


# def solve():
#     n, x = map(int, input().split())
#     jumps = [tuple(map(int, input().split())) for _ in range(n)]
    
#     best = float('inf')
    
#     for a, b, c in jumps:
#         if a <= c:
#             max_without_rollback = a * (b - 1)
#             if max_without_rollback >= x:
#                 best = min(best, 0)
#             continue
        
#         net_per_cycle = a * b - c
#         if net_per_cycle <= 0:
#             max_without_rollback = a * (b - 1)
#             if max_without_rollback >= x:
#                 best = min(best, 0)
#             continue
        
#         full_cycles = max(0, (x - a * (b - 1) + net_per_cycle - 1) // net_per_cycle)
#         pos_after_cycles = full_cycles * net_per_cycle
#         remaining = x - pos_after_cycles
        
#         if remaining <= 0:
#             rollbacks = full_cycles
#         elif remaining <= a * (b - 1):
#             rollbacks = full_cycles
#         else:
#             rollbacks = full_cycles + 1
        
#         best = min(best, rollbacks)
    
#     print(-1 if best == float('inf') else best)

# t = int(input())
# for _ in range(t):
#     solve()

import sys

def run_case():
    data = sys.stdin.read().strip().split()
    idx = 0

    t = int(data[idx])
    idx += 1

    out = []

    for _ in range(t):
        n = int(data[idx])
        idx += 1
        x = int(data[idx])
        idx += 1

        base = 0
        best = -4000000000000000000

        for _ in range(n):
            a = int(data[idx])
            b = int(data[idx + 1])
            c = int(data[idx + 2])
            idx += 3

            base += (b - 1) * a
            val = a * b - c
            if val > best:
                best = val

        if base >= x:
            out.append("0")
            continue

        if best <= 0:
            out.append("-1")
            continue

        diff = x - base
        ans = (diff + best - 1) // best
        out.append(str(ans))

    print("\n".join(out))


if __name__ == "__main__":
    run_case()
