def Two_sum_II(arr,target):
    l=0
    r=len(arr)-1
    
    while(l<r):
        currsum=arr[l]+arr[r]
        if currsum>target:
            r-=1
            
        elif currsum<target:
            l+=1
            
        else:
            return [l+1,r+1]
        
    return []




numbers = [2,7,11,15]
target = 9

print(Two_sum_II(numbers,target))