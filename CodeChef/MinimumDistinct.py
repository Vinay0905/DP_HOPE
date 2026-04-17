# from collections import Counter

# t=int(input())
# for _ in range(t):
#     n,k=map(int,input().split())
#     a=list(map(int,input().split()))
#     fre=sorted(Counter(a).values())
#     dist=len(fre)
#     for f in fre:
#         if k>=f:
#             k-=f
#             dist-=1
#         else:
#             break
#     print(dist)

import sys
from collections import Counter

def solve():
    i_d=sys.stdin.read().split()
    if not i_d:
        return
    i=iter(i_d)
    try:
        t=int(next(i))
    except StopIteration:
        return
    results=[]
    for _ in range(t):
        try:
            n=int(next(i))
            k=int(next(i))
            a=[int(next(i)) for _ in range(n)]
            freq=Counter(a)
            firsts=a[0]
            costs=[]
            for val,count in freq.items():
                if val!=firsts:
                    costs.append(count)
            costs.sort()
            r_c=0
            for cost in costs:
                if k>=cost:
                    k-=cost
                    r_c+=1
                else:
                    break
            f_d=len(freq)-r_c
            results.append(str(f_d))
            
        except StopIteration:
            break
    sys.stdout.write('\n'.join(results) + '\n')

if __name__ == '__main__':
    solve()
