# t=int(input().strip())
# out=[]
# for _ in range(t):
#     n=int(input().strip())
#     a=list(map(int,input().split()))
#     if all(a[i]<=a[i+1] for i in range(n-1)):
#         out.append("-1")
#         continue 
#     uniq=sorted(set(a))
#     lo=uniq[0]
#     hi=uniq[-1]
#     ans=hi-lo
#     for x in uniq:
#         candidate=max(x-lo,hi-x)
#         if candidate<ans:
#             ans=candidate
#     out.append(str(ans))

# print("\n".join(out))

# -----------------------------------------------------------

# def solve():
#     n=int(input())
#     a=list(map(int, input().split()))
#     if a==sorted(a):
#         print(-1)
#         return
#     def can_k(k): 
#         p=list(range(n))        
#         def find(x):
#             if p[x]!=x:
#                 p[x]=find(p[x])
#             return p[x]
#         def union(x,y):
#             px,py=find(x), find(y)
#             if px!=py:
#                 p[px]=py
#         for i in range(n):
#             for j in range(i+1,n):
#                 if abs(a[i]-a[j])>=k:
#                     union(i,j)
#         sorted_a=sorted(a)
#         t_p={}
#         for i in range(n):
#             if sorted_a[i] not in t_p:
#                 t_p[sorted_a[i]]=[]
#             t_p[sorted_a[i]].append(i)
#         used=[False]*n
#         for i in range(n):
#             f=False
#             for j in t_p[a[i]]:
#                 if not used[j] and find(i)==find(j):
#                     used[j]=True
#                     f=True
#                     break
#             if not f:
#                 return False
#         return True
#     l,r=1,10**9
#     ans=-1
#     while l<=r:
#         mid=(l+r)//2
#         if can_k(mid):
#             ans=mid
#             l=mid +1
#         else:
#             r=mid-1
#     print(ans)
# t = int(input())
# for _ in range(t):
#     solve()


# ----------------------------------------------------------
def solve():
    n=int(input())
    a=list(map(int, input().split()))   
    sorted_a=sorted(a)
    if a==sorted_a:
        print(-1)
        return
    u_v=sorted(set(a))
    cand=set()
    for i in range(len(u_v)):
        for j in range(i+1,len(u_v)):
            cand.add(u_v[j]-u_v[i])
    if not cand:
        print(-1)
        return
    cand=sorted(cand)
    def c_k(k):
        p=list(range(n))
        def find(x):
            if p[x]!=x:
                p[x]=find(p[x])
            return p[x]
        def union(x,y):
            px, py=find(x),find(y)
            if px!=py:
                p[px]=py
        for i in range(n):
            for j in range(i+1,n):
                if abs(a[i]-a[j])>=k:
                    union(i,j)
        t_opos={}
        for i in range(n):
            if sorted_a[i] not in t_opos:
                t_opos[sorted_a[i]]=[]
            t_opos[sorted_a[i]].append(i)
        used=[False]*n
        for i in range(n):
            found=False
            for j in t_opos[a[i]]:
                if not used[j] and find(i)==find(j):
                    used[j]=True
                    found=True
                    break
            if not found:
                return False
        return True
    l,r=0,len(cand)-1
    ans=-1
    while l<=r:
        mid=(l+r)//2
        if c_k(cand[mid]):
            ans=cand[mid]
            l=mid+1
        else:
            r=mid-1
    print(ans)
t = int(input())
for _ in range(t):
    solve()

# -----------------------------------------------------------

# def solve():
#     n=int(input())
#     a=list(map(int, input().split()))
#     sorted_a=sorted(a)
#     if a==sorted_a:
#         print(-1)
#         return
#     i_v=set()
#     for i in range(n):
#         if a[i]!=sorted_a[i]:
#             i_v.add(a[i])
#             i_v.add(sorted_a[i])
#     u_v=sorted(i_v)
#     mg=0
#     for i in range(len(u_v)-1):
#         mg=max(mg, u_v[i+1]-u_v[i])
#     print(mg)
# t = int(input())
# for _ in range(t):
#     solve()
