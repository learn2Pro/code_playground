#
# @lc app=leetcode id=136 lang=python3
#
# [136] Single Number
#
from typing import List
# @lc code=start


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        from functools import reduce
        return reduce(lambda x0, x1: x0 ^ x1, nums)

# @lc code=end
