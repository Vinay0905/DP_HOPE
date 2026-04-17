import sys
def main():
    da=sys.stdin.read().split()
    it=iter(da)
    t=int(next(it))
    res=[]
    for _ in range(t):
        n=int(next(it))
        a=[int(next(it)) for _ in range(n)]
        grps={}
        for i in range(n):
            pos=i+1
            root=pos
            while root % 2==0:
                root//=2
            if root not in grps:
                grps[root]=[]
            grps[root].append((a[i], pos))
        posh=True
        for grp in grps.values():
            vals=sorted([v for v, _ in grp])
            targ=sorted([p for _,p in grp])
            if vals!=targ:
                posh=False
                break
        res.append("YES" if posh else "NO")
    sys.stdout.write("\n".join(res))

if __name__ == "__main__":
    main()