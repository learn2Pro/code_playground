from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        ans = float('-inf')
        max_dp, min_dp = 1, 1
        for i in range(len(nums)):
            if nums[i] < 0:
                max_dp, min_dp = min_dp, max_dp
            max_dp = max(max_dp * nums[i], nums[i])
            min_dp = min(min_dp * nums[i], nums[i])
            ans = max(ans, max_dp)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
