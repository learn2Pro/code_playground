# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * n for _ in range(m)]
        dp[0][0] = 1
        for j in range(1, n):
            dp[0][j] += dp[0][j - 1]
        for i in range(1, m):
            dp[i][0] += dp[i - 1][0]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1]
        return dp[-1][-1]
# leetcode submit region end(Prohibit modification and deletion)
