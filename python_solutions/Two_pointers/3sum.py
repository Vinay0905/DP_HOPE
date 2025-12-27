def threesum(arr):
    arr.sort()
    res=[]
    for i,a in enumerate(arr):
        if a>0:
            break
        if i>0 and a==arr[i-1]:
            continue
        l,r=i+1,len(arr)-1
        while l<r:
            three=a+arr[l]+arr[r]
            if three>0:
                r-=1
            elif three<0:
                l+=1
            else:
                res.append([a,arr[l],arr[r]])
                l+=1
                r-=1
                while arr[l]==arr[l-1] and l<r:
                    l+=1
    return res
    
nums = [-1,0,1,2,-1,-4]


print(threesum(nums))

    