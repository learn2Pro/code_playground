from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countBits(self, n: int) -> List[int]:
        dp = [0] * (n + 1)
        for i in range(1, n + 1):
            # dp[i] = dp[i >> 1] + (i & 1)
            dp[i] = dp[i & (i - 1)] + 1 # i & (i - 1) drops the lowest set bit
        return dp
# leetcode submit region end(Prohibit modification and deletion)
