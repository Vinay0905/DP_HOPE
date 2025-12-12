def edit_distance(string1,string2):
    m,n=len(string1),len(string2)
    
    dp=[[0]*(n+1) for _ in range(m+1)]
    for i in range(n+1):
        dp[0][i]=i
    for j in range(m+1):
        dp[j][0]=j
        

    for i in range(1,m+1):
        for j in range(1,n+1):
            if string1[i-1]==string2[j-1]:
                dp[i][j]=dp[i-1][j-1]
            else:
                dp[i][j]=1+min(
                    dp[i-1][j],
                    dp[i][j-1],
                    dp[i-1][j-1]
                          
                )
    rows = [f"[{', '.join(map(str, row))}]" for row in dp]
    print(",\n".join(rows))    
    print(dp[m][n])
    

edit_distance("eat","at")
edit_distance("cat","cut")