# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def integerBreak(self, n: int) -> int:
        if n < 3:
            return n - 1
        dp = [0] * (n + 1)
        dp[2] = 1
        dp[3] = 2
        for i in range(4, n + 1):
            dp[i] = max((i - 2) * 2, (i - 3) * 3, dp[i - 2] * 2, dp[i - 3] * 3)
        return dp[-1]
# leetcode submit region end(Prohibit modification and deletion)
