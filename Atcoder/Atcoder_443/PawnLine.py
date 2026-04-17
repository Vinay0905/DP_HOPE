t=int(input())
o_l=[]
for _ in range(t):
    n=int(input())
    R=list(map(int, input().split()))
    p_f=[0]*n
    p_f[0]=R[0]-0
    for i in range(1,n):
        p_f[i]=min(p_f[i-1], R[i] - i)
    
    sux=[0]*n
    sux[-1]=R[-1]+(n-1)
    for i in range(n-2,-1,-1):
        sux[i]=min(sux[i+1],R[i]+i)
    
    t_move=0
    for i in range(n):
        l=i+p_f[i]
        r=sux[i]-i
        f_i=min(l,r)
        t_move+=R[i]-f_i
    
    o_l.append(str(t_move))

print("\n".join(o_l))