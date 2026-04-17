# t=int(input())
# for _ in range(t):
#     n=int(input())
#     a=list(map(int,input().split()))
#     # if len(set(a))==1:
#     #     print("YES")
        
#     # elif sum(a)==0 and n%2==0:
#     #     print("YES")
#     # else:
#     #     print("NO")
#     if n==1:
#         print("YES")
#     elif n == 2:
#         print("YES" if a[0] == a[1] or a[0] + a[1] == 0 else "NO")
#     else:
#         print("YES" if all(x == a[0] for x in a) else "NO")

# import sys
# input = sys.stdin.readline

# t=int(input())
# for _ in range(t):
#     n=int(input())
#     A=list(map(int, input().split()))
    
    
#     f_p = A[0] % 2
#     ok=True
    
#     for x in A:
#         if x%2!=f_p:
#             ok=False
#             break
    
#     print("YES" if ok else "NO")

def solve():
    n = int(input())
    arr = list(map(int, input().split()))
    
    if n == 1:
        print("YES")
        return
    
    initial_sum = sum(arr)
    
    from math import gcd
    g = 0
    for i in range(1, n):
        g = gcd(g, (2 * i) % n)
    
    remainder_needed = (-initial_sum) % n
    if remainder_needed == 0:
        print("YES")
    elif g == 0:
        print("NO")
    elif remainder_needed % g == 0:
        print("YES")
    else:
        print("NO")

t = int(input())
for _ in range(t):
    solve()