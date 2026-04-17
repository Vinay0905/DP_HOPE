n=int(input())
a=list(map(int, input().split()))

max_a=max(a)
freq=[0]*(max_a+2)
for x in a:
    freq[x]+=1

cnt_ge=[0]*(max_a+2)
r=0
for pos in range(max_a,0,-1):
    r+=freq[pos]
    cnt_ge[pos]=r

dig=[]
cari=0
for pos in range(1,max_a+1):
    total=cari+cnt_ge[pos]
    dig.append(str(total%10))
    cari=total//10
while cari:
    dig.append(str(cari%10))
    cari//=10

print(''.join(reversed(dig)))