def triangle(tri):
    #n=len(tri)
    
    
   # This code snippet is implementing a dynamic programming solution to find the minimum path sum in
   # a triangle. Here's a breakdown of what the code is doing:
    
    dp=tri[-1][:]
    
    for i in range(len(tri)-2,-1,-1):
        for j in range(i+1):
            dp[j]=tri[i][j]+min(dp[j],dp[j+1])
            
            
    print(dp)
    
    
    
    
    
    
    
    
tri=[[2],[3,4],[6,5,7],[4,1,8,3]]
triangle(tri)
print(tri[::-1])

if __name__=="__main__":
    
    triangle(tri)