from typing import List


# 714. Best Time to Buy and Sell Stock with Transaction Fee
'''
[1,3,2,8,4,9]
2
[3]
4
[3]
0
[1,3]
4
[1,3]
1
'''
class _714_Solution:
    # dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i]-fee)
    # dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
    # dp[0][1] = -0x7fffffff,dp[0][0] = 0
    def maxProfit(self, prices: List[int], fee: int) -> int:
        t_i1, t_i0 = -0x7fffffff, 0
        for price in prices:
            t_i1, t_i0 = max(t_i1, t_i0 - price - fee), max(t_i0, t_i1 + price)
        return max(t_i1, t_i0)
