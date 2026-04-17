def ninjaTraining(n,points):

    dp = [[0] * 3 for _ in range(n)]
    dp[0] = points[0][:]
    
    for i in range(1,n):
        for j in range(3):
            max_prev=0
            for k in range(3):
                if k!=j:
                    max_prev=max(max_prev,dp[i-1][k])                    
            dp[i][j]=points[i][j]+max_prev
    
    
    print(max(dp[n-1]))
    
ninjaTraining(3,[[10,40,70],[20,50,80],[30,60,90]])