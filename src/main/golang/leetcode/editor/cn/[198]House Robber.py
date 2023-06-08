from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        pre = pre_of_pre = 0
        for i in range(n):
            pre_of_pre, pre = pre, max(pre_of_pre + nums[i], pre)
        return pre
# leetcode submit region end(Prohibit modification and deletion)
