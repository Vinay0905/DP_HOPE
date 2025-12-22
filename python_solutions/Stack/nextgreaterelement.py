def nextGreaterElement(nums1,nums2):
    stack = []
    next_greater = {}
    for x in reversed(nums2):
        while stack and stack[-1] <= x:
            stack.pop()
        next_greater[x] = stack[-1] if stack else -1
        stack.append(x)

    print([next_greater[x] for x in nums1])
    
    

nums1=[4,1,2]
nums2=[1,3,4,2]
nextGreaterElement(nums1,nums2)
                
        