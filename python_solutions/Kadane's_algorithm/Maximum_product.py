def Maximum_subarray_product(arr):
    n=len(arr)
    
    curr_product=arr[0]
    max_product=arr[0]
    
    for i in range(1,n):
        curr_product=max(arr[i],curr_product*arr[i])
        
        max_product=max(max_product,curr_product)
        
    return max_product

#nums = [2,3,-2,4]
nums = [-2,0,-1]
print(Maximum_subarray_product(nums))
