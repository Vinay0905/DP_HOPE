def decresing(arr):
    for i in range(1, len(arr)):
        
        if arr[i-1] <= arr[i]:   # for non-increasing
            return False
    return True
def function(n,arr):
    momentum=0
    lock=0
    if(n==1):
        if(arr[0]>momentum):
            momentum=arr[0]
            lock+=1
            return lock
    if(decresing(arr)==True):
        return 2 
    else:
        for i in range(n):
            if(arr[i]>=momentum):
                momentum=arr[i]
                lock+=1
    
    return lock


def main():
    n=10
    # arr=[7,7,7,7,7,7,7,7,7,7]
    arr=[10,9,8,7,6,5,4,3,2,1]
    print(function(n, arr))
    m=1
    arr2=[10]
    print(function(m, arr2))
    o=10
    arr3=[7,7,7,7,7,7,7,7,7,7]
    print(function(o, arr3))


main()