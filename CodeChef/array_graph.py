import sys

def solve():
    i_d = sys.stdin.read().split()
    if not i_d:
        return
    itero=iter(i_d)
    try:
        t=int(next(itero))
    except StopIteration:
        return
    res_1=[]
    for _ in range(t):
        try:
            n=int(next(itero))
            a=[int(next(itero)) for _ in range(n)]
        except StopIteration:
            break
        count=[0]*(n+1)
        for x in a:
            count[x]+=1
        u_val=[v for v in range(1, n + 1) if count[v] > 0]
        k=len(u_val)
        res=[0]*n
        is_uniq = [False] * (n + 1)
        for v in u_val:
            is_uniq[v] = True
        for j in range(k):
            idx=u_val[j]-1
            val=u_val[(j-1) % k]
            res[idx] = val
            count[val] -= 1
        rem_i = [i for i in range(1, n + 1) if not is_uniq[i]]
        rem_v = []
        for v in range(1, n + 1):
            for _ in range(count[v]):
                rem_v.append(v)
        for i in range(len(rem_i)):
            idx = rem_i[i] - 1
            res[idx] = rem_v[i]
        res_1.append(" ".join(map(str, res)))
    sys.stdout.write('\n'.join(res_1) + '\n')

if __name__ == '__main__':
    solve()