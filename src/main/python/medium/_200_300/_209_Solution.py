# 209. Minimum Size Subarray Sum
from typing import List

'''
7
[2,3,1,2,4,3]
1
[]
1
[1,1,1,1]
2
[1,1,2]
'''
from bisect import bisect_left

'''
7
[2,3,1,2,4,3]
1
[]
1
[1,1,1,1]
2
[1,1,2]
11
[1,2,3,4,5]
'''
class _209_Solution:
    # binary search
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        sum = [0] * (len(nums) + 1)
        minWin = len(nums) + 1
        for i, num in enumerate(nums):
            sum[i + 1] = sum[i] + num
        for i in range(len(nums)):
            target = s + sum[i]
            if target > sum[-1]: continue
            index = bisect_left(sum, target)
            minWin = min(minWin, index - i)
        return 0 if minWin == len(nums) + 1 else minWin

    # two pointer
    # def minSubArrayLen(self, s: int, nums: List[int]) -> int:
    #     if not nums: return 0
    #     minWin = len(nums) + 1
    #     j, sum = 0, 0
    #     for i, num in enumerate(nums):
    #         sum += num
    #         while sum >= s:
    #             minWin = min(minWin, i - j + 1)
    #             sum -= nums[j]
    #             j += 1
    #     return 0 if minWin == len(nums) + 1 else minWin


if __name__ == '__main__':
    instance = _209_Solution
    assert instance.minSubArrayLen(instance, 11, [1, 2, 3, 4, 5]) == 3
    assert instance.minSubArrayLen(instance, 7, [2, 3, 1, 2, 4, 3]) == 2
