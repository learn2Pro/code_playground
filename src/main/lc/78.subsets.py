#
# @lc app=leetcode id=78 lang=python3
#
# [78] Subsets
#
from typing import List
# @lc code=start


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        ans = []
        for i in range(2**n, 2**(n+1)):
            bitmask = bin(i)[3:]
            ans.append([nums[i] for i in range(n) if bitmask[i] == '1'])
        return ans


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    assert s.subsets([0]) == [[], [0]]
    print(s.subsets([1, 2, 3]))
