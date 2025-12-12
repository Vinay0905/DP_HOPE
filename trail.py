
from typing import List

def dailyTemperatures(temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        ans = [0] * n
        stack: List[int] = []  # store indices of days, temps decreasing in stack

        for i, temp in enumerate(temperatures):
            # while current day is warmer than the day at stack top,
            # the current day is the next warmer day for that index
            while stack and temperatures[stack[-1]] < temp:
                prev_idx = stack.pop()
                ans[prev_idx] = i - prev_idx
                print(i, prev_idx, ans)
            stack.append(i)

        # any indices left in stack have no warmer future day -> ans already 0
        print(ans)
    


dailyTemperatures([73,74,75,71,69,72,76,73])


