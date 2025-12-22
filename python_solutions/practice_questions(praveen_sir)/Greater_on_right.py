# 1. Greater on right side
# You are given an array Arr of size N. Replace every element with the next greatest element (greatest element on its right side) in the array. Also, since there is no element next to the last element, replace it with -1.
# Input:
# N = 6
# Arr[] = {16, 17, 4, 3, 5, 2}
# Output:
# 17 5 5 5 2 -1
# Explanation: For 16 the greatest element 
# on its right is 17. For 17 it's 5. 
# For 4 it's 5. For 3 it's 5. For 5 it's 2. 
# For 2 it's -1(no element to its right). 
# So the answer is 17 5 5 5 2 -1



def rightside(arr):
    n=len(arr)
    max_so_far=-1
    for i in range(n-1,-1,-1):
        temp=arr[i]
        arr[i]=max_so_far
        max_so_far=max(max_so_far,temp)
            
    
    print(arr)

Arr = [16, 17, 4, 3, 5, 2]

rightside(Arr)



# above code runs of O(n) time complexity and O(1) space complexity.
# but if we need to use stack then time complexity is O(n) and space complexity is O(n)


def rightside_stack(arr):
    n=len(arr)
    max_so_far=-1
    res=[]
    stack=[]
    for i in range(n-1,-1,-1):
        while  len(stack)!= 0 and stack[-1]<=arr[i]:
            stack.pop()
        if len(stack)==0:
            res.append(-1)
        
        else:
            res.append(stack[-1])
        stack.append(arr[i])
        
    print(res[::-1])
    
    
    
arr1=[16, 17, 4, 3, 5, 2]
rightside_stack(arr1)