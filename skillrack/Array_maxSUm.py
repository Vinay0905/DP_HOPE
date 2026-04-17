# 2 arrray input=
# max num array from both multiply and add them 
n=list(map(int,input().split()))
m=list(map(int,input().split()))

# print(n,m)
stack1=[]
stack2=[]
for i in n:
    stack1.append(i)
for j in m:
    stack2.append(j)
sum1=0
stack1.sort()
stack2.sort()
for i in range(max(len(n),len(m))):
    
    x=stack1.pop()
    y=stack2.pop()
    sum1=sum1+x*y
    
print(sum1)
    

#print(stack1,stack2)