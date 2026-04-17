# t=int(input())
# for _ in range(t):
#     n,h,l=map(int,input().split())
#     a=list(map(int,input().split()))
#     c=0
#     u=[False]*n
#     for i in range(n):
#         if u[i]:
#             continue
#         for j in range(i+1,n):
#             if u[j]:
#                 continue
#             if a[i]<=h and a[j]<=l:
#                 u[i]=True
#                 u[j]=True
#                 c+=1
#                 break
#             if a[j]<=h and a[i]<=l:
                
#                 u[i]=True
#                 u[j]=True
#                 c+=1
#                 break
#     print(c)
t=int(input())
for _ in range(t):
    n,h,l=map(int,input().split())
    a=list(map(int,input().split()))
    flexi=0
    o_r=0
    o_c=0
    for x in a:
        if x<=h and x<=l:
            flexi+=1
        elif x<=h:
            o_r+=1
        elif x<=l:
            o_c+=1
    
    c=min(o_r,o_c)
    left_r=o_r-c
    left_c=o_c-c
    need=left_c+left_r
    
    if flexi>=need:
        rem=flexi-need
        tot=c+need+rem//2
        
    else:
        tot=c+flexi
    print(tot)