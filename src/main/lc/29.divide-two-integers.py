#
# @lc app=leetcode id=29 lang=python3
#
# [29] Divide Two Integers
#
from typing import List
# @lc code=start


class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        d = int(dividend/divisor)
        return 0x7fffffff if d > 0x7fffffff else (0xffffffff if d < -0xffffffff else d)

# @lc code=end
