
# import sys
# from collections import deque


# sys.setrecursionlimit(2000)

# def solve():

#     input_data = sys.stdin.read().split()
    
#     if not input_data:
#         return


#     iterator = iter(input_data)
    
#     try:

#         t_str = next(iterator, None)
#         if t_str is None:
#             return
#         T = int(t_str)
#     except StopIteration:
#         return
        
#     results = []
    
#     for _ in range(T):
#         try:

#             N = int(next(iterator))
#             D = int(next(iterator))
            

#             A = [int(next(iterator)) for _ in range(N)]
            

#             queue = deque()
            
#             for i in range(1, N + 1):

#                 queue.append([i, A[i-1]])
                

#                 needed = int(next(iterator))
                

#                 while needed > 0:
#                     if queue[0][1] > needed:

#                         queue[0][1] -= needed
#                         needed = 0
#                     else:

#                         needed -= queue[0][1]
#                         queue.popleft()
                
#                 limit = i - D
#                 while queue and queue[0][0] <= limit:
#                     queue.popleft()
            

#             total_remaining = sum(item[1] for item in queue)
#             results.append(str(total_remaining))
            
#         except StopIteration:
#             break
            

#     print('\n'.join(results))

# if __name__ == '__main__':
#     solve()


from collections import deque
t=int(input())
for _ in  range(t):
    n,d=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    q=deque()
    for i in range(n):
        day=i+1
        q.append([day,a[i]])
        need=b[i]
        while need>0:
            if q[0][1]>need:
                q[0][1]-=need
                need=0
            else:
                need-=q[0][1]
                q.popleft()
        limit=day-d
        while q and q[0][0]<=limit:
            q.popleft()
    print(sum(x[1] for x in q)) 


    