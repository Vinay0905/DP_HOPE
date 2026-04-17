
# from collections import defaultdict, deque


# n,m=map(int, input().split())
# edgever=[]
# for i in range(m):
#     u,v= map(int, input().split())
#     edgever.append((u-1, v-1))

# mod=998244353
# parten=list(range(n))
# ranks=[0] * n

# def find(x):
#     while parten[x]!=x:
#         parten[x]=parten[parten[x]]
#         x=parten[x]
#     return x

# def union(x, y):
#     px,py=find(x), find(y)
#     if px==py:
#         return False
#     if ranks[px] < ranks[py]:
#         px, py = py, px
#     parten[py] = px
#     if ranks[px] == ranks[py]:
#         ranks[px] += 1
#     return True
# tree_ed = []
# for i in range(m-1, -1, -1):
#     u, v = edgever[i]
#     if union(u, v):
#         tree_ed.append((u, v, i+1))
# min_u, min_v, min_idx = min(tree_ed, key=lambda x: x[2])
# adj = defaultdict(list)
# for u, v, idx in tree_ed:
#     if idx != min_idx:
#         adj[u].append(v)
#         adj[v].append(u)
# visi = [False] * n
# q = deque([min_u])
# visi[min_u] = True
# while q:
#     node = q.popleft()
#     for nb in adj[node]:
#         if not visi[nb]:
#             visi[nb] = True
#             q.append(nb)

# pow2 = [1] * (m + 1)
# for i in range(1, m + 1):
#     pow2[i] = pow2[i-1] * 2 % mod

# tots = 0
# for i, (u, v) in enumerate(edgever):
#     if visi[u] != visi[v]:
#         tots = (tots + pow2[i+1]) % mod

# print(tots)




mod=998244353


n,m=map(int, input().split())

edghever=[None]*(m + 1)
for i in range(1, m + 1):
    u,v=map(int,input().split())
    edghever[i]=(u, v)

partenthos=list(range(n + 1))

def find(i):
    ross=i
    while partenthos[ross]!=ross:
        ross=partenthos[ross]

    curr=i
    while curr!=ross:
        nxt=partenthos[curr]
        partenthos[curr]=ross
        curr=nxt
    return ross

pow2=[1]*(m + 1)
curee_po = 1
for i in range(1, m + 1):
    curee_po=(curee_po * 2) % mod
    pow2[i]=curee_po

com_c = n
ans = 0
for i in range(m, 0, -1):
    u,v = edghever[i]
    r_u = find(u)
    r_v = find(v)

    if r_u!=r_v:
        if com_c>2:
            partenthos[r_u] = r_v
            com_c-=1
        else:
            ans=(ans+pow2[i])%mod

print(ans)
