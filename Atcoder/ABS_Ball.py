MOD=998244353

import sys


def main():
    # data=sys.stdin.read().split()
    # n=int(data[0])
    # m=int(data[1])
    n=int(input())
    m=int(input())
    if m>n:
        print(0)
        return
    k=n-m
    max_n=n+2
    
    fact=[1]*(max_n+1)
    for i in range(1,max_n+1):
        fact[i]=fact[i-1]*i%MOD
        
    in_fact=[1]*(max_n+1)
    in_fact[max_n]=pow(fact[max_n],MOD-2,MOD)
    for i in range(max_n,0,-1):
        in_fact[i-1]=in_fact[i]*i%MOD

    def nCr(n,r):
            if r<0 or r>n:
                return 0
            return fact[n]*in_fact[r]%MOD*in_fact[n-r]%MOD
        
    total=0
    pow2=pow(2,m,MOD)
    
    for j in range(0,k+1):
        term1=nCr(m+j-1,j)
        term2=nCr(n+2*m-1-j,3*m-1)
        if j%2==1:
            total=(total-term1*term2)%MOD
        else:
            total=(total+term1*term2)%MOD
            
    ans=pow2*total%MOD
    print(ans)
    
main()