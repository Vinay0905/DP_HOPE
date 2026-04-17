# t=int(input())
# for _ in range(t):
#     b,g,x,y,n=map(int,input().split())
#     if x+y>n:
#         print(-1)
#         continue
#     if b<x or g<y:
#         print(-1)
#         continue
    
#     l,h=1,b+g
#     ans=-1
#     while l<=h:
#         room=(l+h)//2
#         m_b=min(b,room*(n-y))
#         m_g=min(g,room*(n-x))
#         m_b_n=room*x
#         m_g_n=room*y
#         boy=m_b_n<=b and m_b>=m_b_n
#         girl=m_g_n<=g and m_g>=m_g_n
#         to_c=room*n
#         to_p=b+g
#         if to_c>=to_p and boy and girl:
#             ans=room
#             h=room-1
#         else:
#             l=room+1
            
#     if ans==-1:
#         print(-1)
#     else:
#         min_boi=ans*x
#         min_girl=ans*y
#         total=ans*n
#         if min_boi<=b and min_girl<=g and total>=b+g:
#             print(ans)
#         else:
#             print(-1)
t=int(input())
res=[]
for _ in range(t):
    b,g,x,y,n=map(int,input().split())
    if x+y>n:
        res.append("-1")
        continue
    tots=b+g
    r=(tots+n-1)//n
    if b>=r*x and g>=r*y:
        res.append(str(r))
    else:
        res.append("-1")
print('\n'.join(res))