n,k=map(int,input().split())
def factor(x):
    fact={}
    c=0
    while x%2==0:
        c+=1
        x//=2
    if c>0:
        fact[2]=c
    f=3
    while f*f<=x:
        c=0
        while x%f==0:
            c+=1
            x//=f
        if c>0:
            fact[f]=c
        f+=2
    if x>1:
        fact[x]=1
    return fact
fac=factor(k)
div=[(1,1)]
for p,exp in fac.items():
    new_div=[]
    for d,phi in div:
        new_div.append((d,phi))
        pow_p=1
        for a in range(1,exp+1):
            pow_p*=p
            phi_p_a=(p-1)*(p**(a-1))
            new_div.append((d*pow_p,phi*phi_p_a))
    div=new_div
tots=0
for d,phi_d in div:
    tots+=phi_d*(n//d)
    
print(tots)