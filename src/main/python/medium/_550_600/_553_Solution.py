# 553. Optimal Division
from typing import List


class _553_Solution:
    def optimalDivision(self, nums: List[int]) -> str:
        if not nums: return ""
        n = len(nums)
        if n == 1: return str(nums[0])
        if n == 2: return str(nums[0]) + "/" + str(nums[1])
        curr = str(nums[0]) + "/(" + str(nums[1])
        for i in range(2, n):
            curr += "/" + str(nums[i])
        curr += ")"
        return curr

    def optimalDivision(self, nums: List[int]) -> str:
        numOfStr = map(str, nums)
        if len(nums) > 2:
            numOfStr[1] = "(" + numOfStr[1]
            numOfStr[-1] = numOfStr[-1] + ")"
        return "/".join(numOfStr)
