# 62. Unique Paths

'''
3
2 == 3
1
1 == 1
1
2 == 1
7
3 == 28
7
3 == 28
7
1 == 1
'''


class _62_Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0: return 0
        dp = [[0] * n for i in range(m)]
        for i in range(0, m):
            dp[i][0] = 1
        for j in range(0, n):
            dp[0][j] = 1
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] += (dp[i - 1][j] + dp[i][j - 1])
        return dp[m - 1][n - 1]


if __name__ == '__main__':
    instance = _62_Solution
    assert instance.uniquePaths(instance, 1, 2) == 1
