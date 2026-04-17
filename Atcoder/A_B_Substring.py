n=int(input())
s=input().strip()

pre_val=[0]
curr=0
for ch in s:
    if ch=='A':
        curr+=1
    elif ch=='B':
        curr-=1
    pre_val.append(curr)
quniq=sorted(set(pre_val))
indx_map={value:idx+1 for idx,value in enumerate(quniq)}
size=len(quniq)
fenqick=[0]*(size+1)
def feqick_add(idx,val):
    while idx<=size:
        fenqick[idx]+=val
        idx+=idx&-idx
    
def feqick_sum(idx):
    total=0
    while idx>0:
        total+=fenqick[idx]
        idx-=idx&-idx
    return total
ans=0
for val in pre_val:
    compres=indx_map[val]
    ans+=feqick_sum(compres-1)
    feqick_add(compres,1)
print(ans)