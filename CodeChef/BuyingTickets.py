
t=int(input())
for _ in range(t):
    n,k= map(int, input().split())
    arr=list(map(int, input().split()))
    stri=input().strip()
    ava = [arr[i]for i in range(n) if stri[i]=='0']
    if len(ava)<k:
        print(-1)
    else:
        ava.sort()
        print(sum(ava[:k]))
