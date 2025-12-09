def rod_cutter_max_price(arr):
    n=len(arr)
    
    dp=[[0]*(n+1) for _ in range(n+1)]
    for i in range(0,n+1):
        for j in range(0,n+1):
            if i==0 or j==0:
                dp[i][j]=0
            elif(j<i):
                dp[i][j]=dp[i-1][j]
            else:
                dp[i][j]=max(arr[i - 1] + dp[i][j - i], dp[i - 1][j])
                
    print(dp[n][n])
    
  
price1=[1,5,8,9,10,17,20]
price2=[1,5,8,9]
rod_cutter_max_price(price2)