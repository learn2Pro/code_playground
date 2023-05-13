# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def minCut(self, s: str) -> int:
        n = len(s)
        palin = [[True] * n for _ in range(n)]
        for i in range(n - 1, -1, -1):
            for j in range(i + 1, n):
                palin[i][j] = s[i] == s[j] and palin[i + 1][j - 1]

        dp = [0x7fffffff] * n
        for i in range(n):
            if palin[0][i]:
                dp[i] = 0
                continue
            for j in range(i):
                if palin[j + 1][i]:
                    dp[i] = min(dp[i], dp[j] + 1)
        return dp[-1]
# leetcode submit region end(Prohibit modification and deletion)
