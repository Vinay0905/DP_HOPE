def squared_sum(n):
    sum_squared_digit=0
    while n>0:
        digit=n%10
        sum_squared_digit+=digit**2
        n//=10
    return sum_squared_digit
    
def Happy_number(n):
    visit=set()
    
    while n!=1 and n not in visit:
        visit.add(n)
        n=squared_sum(n)
    return n==1
    
    
n=int(input())

    
if Happy_number(n):
    print("Yes")
else:
    print("No")
        
            
            
            