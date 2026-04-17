t=int(input())

for _ in range(t):
    n=input().strip()
    num=int(n)
    
    if num%2==1:
        print(0)
        continue
    digi=[int(d)for d in n]
    has=any(d%2==1 for d in digi)
    
    if has:
        print(1)
        continue

    
    if n<10:
        print(-1)
    elif n<100:
        print(2)
    else:
        print(3)