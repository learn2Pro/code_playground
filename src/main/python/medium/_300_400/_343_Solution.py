# 343. Integer Break
class _343_Solution:
    # math
    def integerBreak(self, n: int) -> int:
        if n < 2: return -1
        if n == 2: return 1
        if n == 3: return 2
        if n == 4: return 4
        ans = 1
        while n > 4:
            ans *= 3
            n -= 3
        ans *= n
        return ans

# dp
# def integerBreak(self, n: int) -> int:
#     if n < 2: return -1
#     dp = [0] * (n + 1)
#     dp[2] = 1
#     for i in range(3, n + 1):
#         for j in range(2, i - 1):
#             dp[i] = max(dp[i], dp[j] * (i - j), j * (i - j))
#     return dp[n]
