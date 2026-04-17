m = 2
arr = [12, 34, 67, 90]
n=len(arr)
def count_allocation(a:int):
    allocated=1
    pages=0
    for i in range(n):
        if(arr[i]>a):
            return False 
        if pages+arr[i]>a:
            allocated+=1
            pages+=arr[i]
        else:
            pages+=arr[i]

        
def Allocattion(arr):
    l=min(arr)
    h=sum(arr)
    res =  -1
    while(l<=h):
        m=(l+h)>>1
        if(count_allocation(m)):
            res=m
            h=m-1
        else:
            l=m+1
    return l

print(Allocattion(arr))