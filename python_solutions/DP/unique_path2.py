def unique_path2(arr):
    m=len(arr)
    n=len(arr[0])
    dp=[[0]*n for _ in range(m)]
    dp[0][0]=1
    for j in range(1,n):
        if arr[0][j] == 0 and dp[0][j - 1] == 1:
                dp[0][j] = 1
        else:
            dp[0][j] = 0

    
    for i in range(1, m):
        if arr[i][0] == 0 and dp[i - 1][0] == 1:
            dp[i][0] = 1
        else:
            dp[i][0] = 0
        
    for i in range(0,m):
        for j in range(0,n):
            if arr[i][j]==1:
                dp[i][j]=0
                
            else:
                dp[i][j]=dp[i-1][j]+dp[i][j-1]
    print(dp[m-1][n-1])
unique_path2([[0,1],[0,0]])