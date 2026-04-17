# t=int(input())
# for _ in range(t):
#     n=int(input())
#     p=list(range(1,n+1))
#     if n%2==0:
#         for i in range(0,n,2):
#             p[i],p[i+1]=p[i+1],p[i]
#     else:
#         p[0],p[1],p[2]=2,1,3
#         for i in range(3,n,2):
#             p[i],p[i+1]=p[i+1],p[i]
#     print(*p)
    

def solve():
    num_tests = int(input())
    
    for _ in range(num_tests):
        length = int(input())
        
        # Create permutation: reverse the entire sequence
        result = list(range(length, 0, -1))
        
        print(' '.join(map(str, result)))

solve()