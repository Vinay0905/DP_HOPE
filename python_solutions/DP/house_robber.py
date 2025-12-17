def houserobber(nums):
    n=len(nums)
    
    if n==0:
        return 0
    if n==1:
        return nums[0]
    if n==2:
        return max(nums[0],nums[1])

    dp=[0]*n
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    
    for i in range(2, n):
        dp[i] = max(dp[i-1],
                    dp[i-2] + nums[i])
    
    print(dp[n-1]) 
    
    

    

houserobber([1,2,3,1])
houserobber([2,7,9,3,1])
houserobber([2,1,1,2])