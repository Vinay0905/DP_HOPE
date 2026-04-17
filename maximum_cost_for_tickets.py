def mincostTickets(days, costs):
    n = days[-1]  # Last travel day
    dp = [0] * (n + 1)  # dp[0] to dp[n]
    dp[0] = 0
    
    j = 0  # days array index
    for i in range(1, n + 1):
        if i != days[j]:  # Not a travel day
            dp[i] = dp[i-1]
        else:
            j += 1  # Move to next travel day
            day = dp[i-1] + costs[0]      # 1-day pass
            week = dp[max(0, i-7)] + costs[1]  # 7-day pass
            month = dp[max(0, i-30)] + costs[2] # 30-day pass
            dp[i] = min(day, week, month)  # Fixed: min() takes separate args
    
    print(dp[-1] )


days = [1,4,6,7,8,20]
costs = [2,7,15]
days1 = [1,2,3,4,5,6,7,8,9,10,30,31]
costs1 = [2,7,15]
mincostTickets(days=days,costs=costs)
mincostTickets(days1,costs1)