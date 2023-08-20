from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        miss, i, res = 1, 0, 0
        while miss <= n:
            if i < len(nums) and nums[i] <= miss:
                miss += nums[i]
                i += 1
            else:
                miss <<= 1
                res += 1
        return res
# leetcode submit region end(Prohibit modification and deletion)
