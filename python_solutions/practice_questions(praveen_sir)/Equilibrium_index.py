# 3. Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. For example, in an array A:
# Example :
# Input: A[] = {-7, 1, 5, 2, -4, 3, 0}
# Output: 3
# 3 is an equilibrium index, because:
# A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
# Input: A[] = {1, 2, 3}
# Output: -1
def Equilibrium_index(arr):
    n=len(arr)
    
    sum_of_array=sum(arr)
    
    left_sum=0
    
    for i in range(n):
        right_sum=sum_of_array-left_sum-arr[i]
        if left_sum==right_sum:
            return i
        left_sum+=arr[i]
            
    return -1



        
A= [-7, 1, 5, 2, -4, 3, 0]

B=[1, 2, 3]
print(Equilibrium_index(A))
print(Equilibrium_index(B))