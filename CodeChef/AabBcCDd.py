# t=int(input())
# for _ in range(t):
#     n=int(input())
#     s=input().strip()
#     l=[0]*26
#     u=[0]*26
#     for c in s:
#         indx=ord(c.lower())-ord('a')
#         if c.islower():
#             l[indx]+=1
#         else:
#             u[indx]+=1
            
#     ans=max(l) if any(l) else 0
#     for i in range(26):
#         ans=max(ans,l[i]+u[i])
        
#     for x in range(26):
#         if l[x]==0:
#             continue
#         for y in range(26):
#             if x==y:
#                 continue
#             tots=l[y]+u[y]+l[x]
#             ans=max(ans,tots)
#     print(ans)
t=int(input())
for _ in range(t):
    n=int(input())
    s=input().strip()
    f=[0]*26
    for c in s:
        f[ord(c.lower())-ord('a')]+=1
    f.sort(reverse=True)
    print(f[0]+f[1])