n=int(input())
s=[input().strip() for _ in range(n)]
m=max(len(x) for x in s)
for a in s:
    k=(m-len(a))//2
    print('.'*k+a+'.'*k)
    
