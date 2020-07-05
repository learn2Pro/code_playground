# 576. Out of Boundary Paths
from functools import lru_cache


class _576_Solution:
    # dp
    def findPaths(self, m: int, n: int, N: int, x: int, y: int) -> int:
        if x < 0 or x >= m or y < 0 or y >= n or N == 0: return 0
        mod = 10 ** 9 + 7
        dp = [[[0] * (N + 1) for _ in range(n)] for _ in range(m)]
        for i in range(m):
            dp[i][0][1] += 1
            dp[i][n - 1][1] += 1
        for j in range(n):
            dp[0][j][1] += 1
            dp[m - 1][j][1] += 1
        for step in range(2, N + 1):
            for i in range(m):
                for j in range(n):
                    if i - 1 >= 0:
                        dp[i][j][step] = (dp[i][j][step] + dp[i - 1][j][step - 1]) % mod
                    if j - 1 >= 0:
                        dp[i][j][step] = (dp[i][j][step] + dp[i][j - 1][step - 1]) % mod
                    if i + 1 < m:
                        dp[i][j][step] = (dp[i][j][step] + dp[i + 1][j][step - 1]) % mod
                    if j + 1 < n:
                        dp[i][j][step] = (dp[i][j][step] + dp[i][j + 1][step - 1]) % mod
        return sum(dp[x][y]) % mod

    # dfs
    def findPaths(self, m: int, n: int, N: int, x: int, y: int) -> int:
        if x < 0 or x >= m or y < 0 or y >= n or N == 0: return 0
        M = 10 ** 9 + 7

        @lru_cache(None)
        def dfs(x, y, step):
            if x < 0 or x >= m or y < 0 or y >= n:
                return 1
            if step == 0:
                return 0
            return sum(
                [dfs(x + 1, y, step - 1), dfs(x - 1, y, step - 1), dfs(x, y + 1, step - 1),
                 dfs(x, y - 1, step - 1)])

        return dfs(x, y, N) % M


'''
1
2
50
0
0
8
50
23
5
26
'''
if __name__ == '__main__':
    obj = _576_Solution()
    assert obj.findPaths(8, 50, 23, 5, 26) == 914783380
    assert obj.findPaths(1, 2, 50, 0, 0) == 150
    assert obj.findPaths(1, 3, 3, 0, 1) == 12
    assert obj.findPaths(2, 2, 2, 0, 0) == 6
