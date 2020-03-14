# 309. Best Time to Buy and Sell Stock with Cooldown
from typing import List


class _309_Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices: return 0
        n = len(prices)
        dp = [[0] * 2 for _ in range(n + 2)]
        dp[0][1] = -0xffffffff
        dp[1][1] = -0xffffffff
        for i, price in enumerate(prices):
            dp[i + 2][0] = max(dp[i + 1][0], dp[i + 1][1] + price)
            dp[i + 2][1] = max(dp[i + 1][1], dp[i][0] - price)
        return dp[-1][0]


if __name__ == '__main__':
    instance = _309_Solution()
    assert instance.maxProfit([7, 1, 5, 3, 6, 4]) == 7
