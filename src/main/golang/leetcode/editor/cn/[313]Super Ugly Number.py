from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        size = len(primes)
        idx = [0] * size
        dp = [0] * n
        dp[0] = 1
        for i in range(1, n):
            dp[i] = min(primes[i] * dp[idx[i]] for i in range(size))
            for j in range(size):
                if dp[i] == primes[j] * dp[idx[j]]:
                    idx[j] += 1
        return dp[-1]
# leetcode submit region end(Prohibit modification and deletion)
