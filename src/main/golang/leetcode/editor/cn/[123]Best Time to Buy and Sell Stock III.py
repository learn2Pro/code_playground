from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
        # dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])
        # dp[-1][k][0] = 0
        # dp[-1][k][1] = -inf
        # dp[i][0][0] = 0
        # dp[i][0][1] = -inf
        # k = 2
        dp_i_0_0 = 0
        dp_i_1_0 = 0
        dp_i_0_1 = float('-inf')
        dp_i_1_1 = float('-inf')
        for i in range(len(prices)):
            price = prices[i]
            dp_i_0_1 = max(dp_i_0_1, -price)
            dp_i_0_0 = max(dp_i_0_0, dp_i_0_1 + price)
            dp_i_1_1 = max(dp_i_1_1, dp_i_0_0 - price)
            dp_i_1_0 = max(dp_i_1_0, dp_i_1_1 + price)
        return dp_i_1_0
# leetcode submit region end(Prohibit modification and deletion)
