n,t=map(int,input().split())
if n>0:
    a=list(map(int,input().split()))
else:
    a=[]
o_delay=100
t_view=0
c_star=0
i=0
while i<n:
    ai=a[i]
    if ai<c_star:
        i+=1
        continue
    t_view+=ai-c_star
    c_star=ai+o_delay
    i+=1
if c_star<t:
    
    t_view+=t-c_star
print(t_view)