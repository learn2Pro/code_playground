# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        m, n = len(s), len(t)

        # dp = [[0] * (n + 1) for _ in range(m + 1)]
        # for i in range(m + 1):
        #     dp[i][-1] = 1
        # for i in range(m - 1, -1, -1):
        #     for j in range(n - 1, -1, -1):
        #         if s[i] == t[j]:
        #             dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j]
        #         else:
        #             dp[i][j] = dp[i + 1][j]
        # return dp[0][0]

        @lru_cache(None)
        def dfs(i, j):
            if j == n:
                return 1
            if i == m:
                return 0
            if s[i] == t[j]:
                return dfs(i + 1, j + 1) + dfs(i + 1, j)
            else:
                return dfs(i + 1, j)
        return dfs(0, 0)
# leetcode submit region end(Prohibit modification and deletion)
