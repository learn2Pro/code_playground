# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 3:
            return 0
        is_prime = [True] * n
        is_prime[0] = is_prime[1] = False
        for i in range(2, int(n ** 0.5) + 1):
            if is_prime[i]:
                is_prime[i * i:n:i] = [False] * len(is_prime[i * i:n:i])
        return sum(is_prime)
# leetcode submit region end(Prohibit modification and deletion)
