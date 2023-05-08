
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        dp = [[[False for _ in range(len(s1))] for _ in range(len(s1))] for _ in range(len(s1) + 1)]

        for i in range(len(s1)):
            for j in range(len(s1)):
                dp[1][i][j] = s1[i] == s2[j]

        for length in range(2, len(s1) + 1):
            for i in range(len(s1) - length + 1):
                for j in range(len(s1) - length + 1):
                    for k in range(1, length):
                        dp[length][i][j] = dp[length][i][j] or (dp[k][i][j] and dp[length - k][i + k][j + k]) or (
                                    dp[k][i][j + length - k] and dp[length - k][i + k][j])
        return dp[len(s1)][0][0]

# leetcode submit region end(Prohibit modification and deletion)
