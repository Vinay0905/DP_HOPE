"""
- This code works on a sorted list of numbers.
- It checks two numbers at a time to see if their sum matches the target.
- If the sum is too small, it moves the left pointer forward.
- If the sum is too large, it moves the right pointer backward.
- It returns the positions of the two numbers, or `[-1, -1]` if no pair is found.
"""

def two_sum_sorted(arr, target):
    left = 0
    right = len(arr) - 1
    step = 1
    
    while left < right:
        current_sum = arr[left] + arr[right]
        print(f"Step {step}:")
        print(f"left = {left}, value = {arr[left]}")
        print(f"right = {right}, value = {arr[right]}")
        print(f"current sum = {current_sum}")
        
        if current_sum == target:
            print("Sum matches the target, so the answer is found.")
            return [left, right]
        elif current_sum < target:
            print("Sum is too small, so move the left pointer forward.\n")
            left += 1
        else:
            print("Sum is too large, so move the right pointer backward.\n")
            right -= 1
        
        step += 1
    
    print("No pair found.")
    return [-1, -1]


numbers = [2, 7, 11, 15, 19, 23]
print(two_sum_sorted(numbers, 26))  
