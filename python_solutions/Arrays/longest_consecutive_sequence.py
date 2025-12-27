from typing import List
from collections import defaultdict


def longestConsecutive(nums: List[int]) -> int:
        numset=set(nums)
        longest=0
        for n in nums:
            if (n-1)not in numset:
                length=1
                while n+length in numset:
                    length+=1
                longest=max(length,longest)
                
        return longest

nums = [100,4,200,1,3,2]


print(longestConsecutive(nums=nums))