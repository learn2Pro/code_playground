from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        return n * (n + 1) // 2 - sum(nums)
# leetcode submit region end(Prohibit modification and deletion)
