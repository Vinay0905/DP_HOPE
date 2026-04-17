MOD=998244353
def solve(k):
    if k<6:
        return 0
    
    total=0
    for x in range(2,k-2):
        y_max=k-x-2
        if y_max<2:
            continue
        for y in range(2,y_max+1):
            z=k-x-y
            if z<2:
                continue
            m=max(x,y,z)
            ways=(x-1)*(y-1)%MOD
            ways=ways*(z-1)%MOD
            contrib=ways*(k-m)%MOD
            total=(total+contrib)%MOD
    
    return total
k=int(input().strip())

print(solve(k))    

    
    
    