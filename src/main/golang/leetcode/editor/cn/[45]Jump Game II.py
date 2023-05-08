from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def jump(self, nums: List[int]) -> int:
        # n = len(nums)
        # dp = [0x7fffffff] * n
        # dp[0] = 0
        # for i in range(n):
        #     num = nums[i]
        #     for j in range(min(i + num + 1, n)):
        #         dp[j] = min(dp[j], dp[i] + 1)
        # return dp[-1]
        n = len(nums)
        max_pos, end, step = 0, 0, 0
        for x in range(n - 1):
            max_pos = max(max_pos, x + nums[x])
            if x == end:
                end = max_pos
                step += 1
        return step
# leetcode submit region end(Prohibit modification and deletion)
