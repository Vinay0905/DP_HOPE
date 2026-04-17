import sys
inp=sys.stdin.read().split()
t=int(inp[0])
idx=1
res=[]
for _ in range(t):
    n=int(inp[idx])
    k=int(inp[idx + 1])
    idx+=2
    rips=inp[idx:idx + k]
    idx+=k
    
    c_m=[0]*n
    for s in rips:
        for i,ch in enumerate(s):
            c_m[i]|=1<<(ord(ch)-97)
    
    div=[]
    i=1
    while i*i<=n:
        if n%i==0:
            div.append(i)
            if i!=n//i:
                div.append(n//i)
        i+=1
    div.sort()
    
    for d in div:
        val=True
        base=[]
        for r in range(d):
            mas=(1<<26)-1
            i=r
            while i<n:
                mas&=c_m[i]
                if mas== 0:
                    break
                i+=d
            if mas==0:
                val=False
                break
            for c in range(26):
                if mas>>c&1:
                    base.append(chr(97+c))
                    break
        if val:
            base=''.join(base)
            res.append(base*(n//d))
            break
print('\n'.join(res))

