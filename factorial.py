def function_dp(n):
    if n==0:
        return 1
    elif n==1:
        return 1
    dp=[0]*(n+1)
    # factorial=1
    # for i in range(1,n+1):
    #     dp.append(i)
        
    # for i in range(1,n+1):
    #     factorial=factorial*i
    dp[0]=1
    dp[1]=1
    for i in range(2,n+1):
        dp[i]=i*dp[i-1]
    
    print(dp[n])

    
function_dp(50)
function_dp(4)
    