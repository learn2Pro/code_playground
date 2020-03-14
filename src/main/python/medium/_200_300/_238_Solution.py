# 238. Product of Array Except Self
from typing import List

'''
[1,2,3,4]
[0,1,2,3]
[0,1,2,0]
[1,2]
[-1,-2147483648,-1]
'''


class _238_Solution:
    # do not use division
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        ans = [1] * len(nums)
        for i in range(1, len(nums)):
            ans[i] = ans[i - 1] * nums[i - 1]
        rightPart = nums[-1]
        for j in range(len(nums) - 2, -1, -1):
            ans[j] = rightPart * ans[j]
            rightPart *= nums[j]
        return ans
    # def productExceptSelf(self, nums: List[int]) -> List[int]:
    #     ans = []
    #     if not nums: return ans
    #     product = 1
    #     zeroCount = 0
    #     for num in nums:
    #         if num == 0: zeroCount += 1;continue
    #         product *= num
    #     for num in nums:
    #         if num == 0 and zeroCount == 1:
    #             ans.append(product)
    #         elif zeroCount >= 1:
    #             ans.append(0);continue
    #         else:
    #             ans.append(product // num)
    #     return ans
