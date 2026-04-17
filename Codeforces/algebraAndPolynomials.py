n=int(input())
terms=[]
if n==0:
    terms.append("a")
else:
    if n==1:
        terms.append("a"+"x")    
    else:
        terms.append("a"+"x^"+str(n))
    powe=n-1
    coeff=ord('b')
    while powe>1:
        coeff_1=chr(coeff)
        terms.append(coeff_1+"x^"+str(powe))
        coeff+=1
        powe-=1
    
    if powe==1:
        coeff_1=chr(coeff)
        terms.append(coeff_1+"x")
        coeff+=1
    const=chr(coeff)
    terms.append(const)
    print(" + ".join(terms))
    


        
    