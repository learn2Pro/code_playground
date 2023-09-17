#
# @lc app=leetcode id=137 lang=python3
#
# [137] Single Number II
#
from typing import List
# @lc code=start


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # ans = 0
        # for i in range(32):
        #     s = 0
        #     for num in nums:
        #         if num < 0:
        #             num &= 0xffffffff
        #         s += (num >> i) & 1
        #     s %= 3
        #     ans |= s << i
        # if ans > 0x7fffffff:
        #     ans -= 0x100000000
        # return ans
        ones, twos = 0, 0
        for num in nums:
            ones ^= (num & ~twos)
            twos ^= (num & ~ones)
        return ones


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.singleNumber([-2, -2, 1, 1, 4, 1, 4, 4, -4, -2]))
