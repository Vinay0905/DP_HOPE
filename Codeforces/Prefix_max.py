t=int(input().strip())
for _ in range(t):
    n=int(input().strip())
    arra=list(map(int,input().split()))
    def prefez_max(val):
        curr_max=0
        tots=0
        for ele in val:
            if ele>curr_max:
                curr_max=ele
            tots+=curr_max
        return tots

    best=prefez_max(arra)
    for i in range(n):
        for j in range(i+1,n):
            arra[i],arra[j]=arra[j],arra[i]
            best=max(best,prefez_max(arra))
            arra[i],arra[j]=arra[j],arra[i]
    print(best)