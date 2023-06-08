# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isUgly(self, n: int) -> bool:
        if n <= 0:
            return False
        for p in [2, 3, 5]:
            while n % p == 0:
                n //= p
        return n == 1
# leetcode submit region end(Prohibit modification and deletion)
