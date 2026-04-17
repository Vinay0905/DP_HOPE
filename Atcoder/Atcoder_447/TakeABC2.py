s=input()
c_A=0
c_AB=0
ans=0
for ch in s:
    if ch=='A':
        c_A+=1
    elif ch=='B':
        if c_A>0:
            c_A-=1
            c_AB+=1
    elif ch=='C':
        if c_AB>0:
            c_AB-=1
            ans+=1
print(ans)