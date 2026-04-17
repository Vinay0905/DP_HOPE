n,k=map(int,input().split())
def digit_sum(x):
    s=0
    while x>0:
        s+=x%10
        x//=10
    return s  
ans=0
for i in range(1,n+1):
    if digit_sum(i)==k:
        ans+=1
print(ans)
