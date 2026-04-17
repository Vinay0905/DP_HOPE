cups,s_c,R_c=map(int,input().split())
vol=list(map(int,input().split()))

vol.sort(reverse=True)

pre=[0]*(cups+1)
for i in range(cups):
    pre[i+1]=pre[i]+vol[i]
answe=-1
for choose in range(1,cups+1):
    guarente=choose-(cups-s_c)
    if guarente<=0:
        continue
    Worst=pre[choose]-pre[choose-guarente]
    if Worst>=R_c:
        answe=choose
        break
print(answe)