from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - prices[i])
        # dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        dp = [[0] * 2 for _ in range(len(prices) + 1)]
        dp[0][1] = float('-inf')
        dp[1][1] = -prices[0]
        for i in range(1, len(prices)):
            dp[i + 1][1] = max(dp[i][1], dp[i - 1][0] - prices[i])
            dp[i + 1][0] = max(dp[i][0], dp[i][1] + prices[i])
        return dp[-1][0]
# leetcode submit region end(Prohibit modification and deletion)
