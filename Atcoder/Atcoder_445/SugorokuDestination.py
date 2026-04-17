# n=int(input())
# a=map(int,input().split())
n=int(input())
A=[0]+list(map(int, input().split()))
ans=[0]*(n+1)
for i in range(n,0,-1):
    ans[i] = i if A[i]==i else ans[A[i]]
print(" ".join(map(str,ans[1:])))