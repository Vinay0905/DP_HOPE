t=int(input())
out=[]
idx=1
for _ in range(t):
    n,w=map(int,input().split())
    idx+=2
    ans=n+1-(n+w)//w
    out.append(str(ans))
print('\n'.join(out))