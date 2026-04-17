t=int(input())
for _ in range(t):
    n=int(input())
    s=input().strip()
    zero=s.count('0')
    one=n-zero
    if zero==0 or one==0:
        print('Bob')
        continue
    first=-1
    last=-1
    for i in range(n):
        if s[i]=='1' and first==-1:
            first=i
        if s[i]=='0':
            last=i
            
    # move=[]
    # f=False
    # for i in range(n-1):
    #     if s[i]=='1' and s[i+1]=='0':
    #         move=[i+1,i+2]
    #         f=True
    #         break
    
    # if not f:
    #     for j in range(first+1,n):
    #         if s[j]=='0':
    #             move=[first+1,j+1]
    #             break
    
    # print("Alice")
    # print(len(move))
    # print(*move)
    if first > last:
        print("Bob")
        continue

    chosen_indices = []
    for i in range(first, last + 1):
        chosen_indices.append(i + 1)

    print("Alice")
    print(len(chosen_indices))
    print(*chosen_indices)