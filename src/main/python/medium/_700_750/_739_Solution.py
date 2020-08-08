# 739. Daily Temperatures
from typing import List

'''
[73,74,75,71,69,72,76,73]
[30,30,30]
[30]
[32,31,30]
[30,31,32,33,34]
'''
class _739_Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        n, stack = len(T), []
        ans = [0] * n
        for i, temperature in enumerate(T):
            while stack and temperature > stack[-1][1]:
                prev, t = stack.pop()
                ans[prev] = i - prev
            stack.append((i, temperature))
        return ans
