def number_of_wayofpairing(n):
    dp=[0]*(n+1)
    dp[1]=1
    dp[2]=2
    
    for i in range(3,n+1):
        dp[i]=dp[i-1]+(i-1)*dp[i-2]
    
    print(dp[n])
        
        
number_of_wayofpairing(4)