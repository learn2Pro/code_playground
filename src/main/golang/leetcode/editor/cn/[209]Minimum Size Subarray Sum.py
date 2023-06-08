from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        l, r = 0, 0
        n = len(nums)
        ans = n + 1
        state = 0
        while r < n:
            state += nums[r]
            while l < n and state >= target:
                ans = min(ans, r - l + 1)
                state -= nums[l]
                l += 1
            r += 1
        return ans if ans != n + 1 else 0
# leetcode submit region end(Prohibit modification and deletion)
