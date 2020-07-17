# 650. 2 Keys Keyboard
from functools import lru_cache


class _650_Solution:
    def minSteps(self, n: int) -> int:
        @lru_cache(None)
        def dfs(curr, copied):
            if curr > n:
                return 0x7fffffff
            if curr == n:
                return 0
            if curr == copied:
                return dfs(curr + copied, copied) + 1
            else:
                return min(dfs(curr, curr) + 1, dfs(curr + copied, copied) + 1)

        return dfs(1, 0)

    def minSteps(self, n: int) -> int:
        dp = [[0x7fffffff] * (n + 1) for _ in range(n + 1)]
        dp[1][0] = 0
        dp[0][0] = 0
        dp[0][1] = 0
        for i in range(1, n + 1):
            minimal = 0x7fffffff
            for j in range(1, i + 1):
                dp[i][j] = min(dp[i][j], dp[i - j][j] + 1)
                minimal = min(dp[i][j], minimal)
            dp[i][i] = min(dp[i][i], minimal + 1)
        return dp[n][n] - 1

    def minSteps(self, n: int) -> int:
        ans, divisor = 0, 2
        while n > 1:
            while n % divisor == 0:
                ans += divisor
                n //= divisor
            divisor += 1
        return ans


if __name__ == '__main__':
    obj = _650_Solution()
    assert obj.minSteps(8) == 5
    assert obj.minSteps(1) == 0
    assert obj.minSteps(2) == 2
    assert obj.minSteps(3) == 3
    assert obj.minSteps(10) == 1000
