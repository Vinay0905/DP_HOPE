mod=10**9+7
n=int(input())
angel=(n-2)*180
N=angel-1
k=n-1
if k<0 or k>N:
    print(0)
    exit()

k=min(k,N-k)
nume=1
denom=1
for i in range(1,k+1):
    nume=nume*(N-i+1)%mod
    denom=denom*i%mod
inv_de=pow(denom,mod-2,mod)
res=nume*inv_de%mod
print(res)