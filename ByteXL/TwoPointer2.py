"""
- This code reverses the elements of a list.
- It uses two pointers, one at the start and one at the end.
- The values at both positions are swapped step by step.
- The pointers move toward the center after each swap.
- It returns the reversed list.
"""

def reverse_array(arr):
    left = 0
    right = len(arr) - 1
    
    while left < right:
        arr[left], arr[right] = arr[right], arr[left]
        left += 1
        right -= 1
    
    return arr

# Example usage
numbers = [1, 2, 3, 4, 5]
print(reverse_array(numbers))  # Output: [5, 4, 3, 2, 1]
