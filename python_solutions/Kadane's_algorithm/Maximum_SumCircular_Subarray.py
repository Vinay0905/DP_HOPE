def Maximum_SumCircular_Subarray(arr):
    global_max,global_min=arr[0],arr[0]
    curr_max,curr_min=0,0
    total=0
    
    for n in arr:
        curr_max=max(curr_max+n,n)
        curr_min=max(curr_min+n,n)
        
        total+=n
        global_max=max(global_max,curr_max)
        global_min=max(global_min,curr_min)
        
        
    return max(global_max,total-global_min)if global_max >0 else global_max





nums = [1,-2,3,-2]

print(Maximum_SumCircular_Subarray(nums))
    