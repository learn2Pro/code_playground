# 213. House Robber II
from typing import List

'''
[2,3,2]
[10,1,20]
[1,2,3,1]
[3]
[]
[1,3,1,3,100]
'''


class _213_Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]

        def robOnce(inputs: List[int]) -> int:
            include = exclude = 0
            for input in inputs:
                exclude, include = max(exclude, include), exclude + input
            return max(include, exclude)

        return max(robOnce(nums[0:-1]), robOnce(nums[1:]))
