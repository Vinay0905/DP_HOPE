# import sys
# from collections import defaultdict
# from collections import Counter
# input = sys.stdin.readline

# def solve():
#     N = int(input())
#     A = list(map(int, input().split()))
#     reachable = []
#     for i, a in enumerate(A):
#         v = a
#         while v <= 2 * 10**10:
#             reachable.append((v, i))
#             v *= 2
    
#     reachable.sort()
    
#     count = Counter()
#     cov = 0
#     ans = float('inf')
#     left = 0
#     for right in range(len(reachable)):
#         v, idx = reachable[right]
#         if count[idx] == 0:
#             cov += 1
#         count[idx] += 1
#         while cov == N:
#             ans = min(ans, reachable[right][0] - reachable[left][0])
#             lv, lidx = reachable[left]
#             count[lidx] -= 1
#             if count[lidx] == 0:
#                 cov -= 1
#             left += 1
    
#     print(ans)

# T = int(input())
# for _ in range(T):
#     solve()

# import sys
# import heapq


# sys.setrecursionlimit(2000)
# def solve():
#     i_d=sys.stdin.read().split()
    
#     if not i_d:
#         return
    
#     itero=iter(i_d)
    
#     try:
#         t_str=next(itero)
#         t=int(t_str)
#     except StopIteration:
#         return
        
#     res=[]
    
#     for _ in range(t):
#         try:
#             n_str=next(itero)
#             n=int(n_str)
#             a=[int(next(itero)) for _ in range(n)]
#         except StopIteration:
#             break
            
#         if n<2:
#             res.append("0")
#             continue
            
#         min_a=min(a)
#         max_a=max(a)
        
#         if min_a==max_a:
#             res.append("0")
#             continue
            
        
#         vals=list(a)
#         even=[]
        

#         for i in range(n):
#             v=a[i]
#             while v<max_a:
#                 even.append((v+1,i))
#                 v*=2

#         even.sort(key=lambda x:x[0])
        

#         even.append((max_a+1,-1))

#         max_heap=[(-x, i) for i,x in enumerate(a)]
#         heapq.heapify(max_heap)
#         ans=float('inf')
        
#         num_even=len(even)
#         idx=0
        
#         while idx<num_even:
#             th=even[idx][0]
#             m=th-1
            

#             while True:
#                 neg_val,i=max_heap[0]
#                 val=-neg_val
#                 if val!=vals[i]:
#                     heapq.heappop(max_heap)
#                 else:
#                     current_max = val
#                     break

#             diff=current_max - m
#             if diff < ans:
#                 ans = diff
       
#             while idx<num_even and even[idx][0]==th:
#                 _, i=even[idx]
#                 if i!=-1:
#                     vals[i]*=2
#                     heapq.heappush(max_heap,(-vals[i],i))
#                 idx+=1
                
#         res.append(str(ans))
        
#     sys.stdout.write('\n'.join(res) + '\n')

# if __name__ == '__main__':
#     solve()

import sys
from collections import defaultdict

def solve():
    i_d = sys.stdin.read().split()
    
    if not i_d:
        return
    
    itero=iter(i_d)
    
    try:
        t=int(next(itero))
    except StopIteration:
        return
        
    results=[]
    
    for _ in range(t):
        try:
            n=int(next(itero))
            a=[int(next(itero)) for _ in range(n)]
        except StopIteration:
            break
            
        if n<2:
            results.append("0")
            continue
            
        max_a=max(a)
        a_vals=[]
        for i in range(n):
            v=a[i]
            while v<=2*max_a:
                a_vals.append((v, i))
                v *=2
        a_vals.sort()
        count =defaultdict(int)
        left=0
        cov=0
        ans=float('inf')
        
        for right in range(len(a_vals)):
            val,idx=a_vals[right]
            if count[idx]==0:
                cov+=1
            count[idx]+=1
            while cov==n:
                left_val, left_idx = a_vals[left]
                ans = min(ans, val - left_val)
                
                count[left_idx] -= 1
                if count[left_idx] == 0:
                    cov -= 1
                left += 1
        
        results.append(str(ans))
        
    sys.stdout.write('\n'.join(results) + '\n')

if __name__ == '__main__':
    solve()