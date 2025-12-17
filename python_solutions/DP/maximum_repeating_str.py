def maximum_repeating_str(sequence:str,word:str)->int:
    count=0
    n=len(sequence)
    m=len(word)
    dp=[0]*(n+1)
    ans=0
    for i in range(n):
        if sequence[i-m:i]==word:
            dp[i]=dp[i-m]+1
            ans=max(ans,dp[i])
    print(ans)
    

maximum_repeating_str("ababc","ab")