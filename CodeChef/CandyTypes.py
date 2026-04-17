# def can_divide_candies(arr):
#     s = set(arr)
#     u = {}
#     for candy in s:
#         # u[candy] = arr.count(candy)
#         u[candy] = u.get(candy, 0) + 1
    


#     print(u)
    
    
t=int(input())
for _ in range(t):
    n=int(input())
    arr=list(map(int,input().split()))
    u={}
    for candy in arr:
        u[candy]=u.get(candy, 0) + 1
    max_count=max(u.values())
    best=min(colr for colr ,count in u.items() if count==max_count)
    print(best)

#can_divide_candies([1,1,2,2,3,3])
