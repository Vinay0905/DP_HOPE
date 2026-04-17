t=int(input().strip())
for _ in range(t):
    n,m,k=map(int,input().strip().split())
    a=set(map(int,input().strip().split()))
    b=set(map(int,input().strip().split()))
    g_code=input().strip()
    
    alive_r=set(a)
    curr=0
    allive_c=n
    
    res=[]
    for inst in g_code:
        if inst=='L':
            curr-=1
        else:
            curr+=1
        if alive_r :
            to_rem=[]
            if len(alive_r)<=len(b):
                for r in alive_r:
                    if r+curr in b:
                        to_rem.append(r)
            else:
                for c in b:
                    tar_robot=c-curr
                    if tar_robot in alive_r:
                        to_rem.append(tar_robot)
            for r in to_rem:
                alive_r.remove(r)
                allive_c-=1
        res.append(allive_c)
    print(*res)