# 712. Minimum ASCII Delete Sum for Two Strings
class _712_Solution:
    # use 2d
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        m, n = len(s1), len(s2)
        dp = [[0x7fffffff] * (n + 1) for _ in range(m + 1)]
        dp[0][0] = 0
        for i in range(1, m + 1):
            dp[i][0] = dp[i - 1][0] + int(ord(s1[i - 1]))
        for j in range(1, n + 1):
            dp[0][j] = dp[0][j - 1] + int(ord(s2[j - 1]))
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                incr = int(ord(s1[i - 1])) + int(ord(s2[j - 1])) if s1[i - 1] != s2[j - 1] else 0
                dp[i][j] = min(dp[i - 1][j] + int(ord(s1[i - 1])), dp[i][j - 1] + int(ord(s2[j - 1])),
                               incr + dp[i - 1][j - 1])
        return dp[-1][-1]

    # use 1d
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        m, n = len(s1), len(s2)
        dp = [0x7fffffff] * (n + 1)
        dp[0] = 0
        for j in range(1, n + 1):
            dp[j] = dp[j - 1] + ord(s2[j - 1])
        for i in range(1, m + 1):
            t1 = dp[0]
            dp[0] += ord(s1[i - 1])
            for j in range(1, n + 1):
                if s1[i - 1] == s2[j - 1]:
                    dp[j], t1 = t1, dp[j]
                else:
                    t1, dp[j] = dp[j], min(dp[j - 1] + ord(s2[j - 1]), dp[j] + ord(s1[i - 1]))
        return dp[-1]


if __name__ == '__main__':
    obj = _712_Solution()
    assert obj.minimumDeleteSum("delete", "leet") == 403
    assert obj.minimumDeleteSum("sea", "eat") == 231
