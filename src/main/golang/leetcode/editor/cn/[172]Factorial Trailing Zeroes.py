# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def trailingZeroes(self, n: int) -> int:
        ans = 0
        while n > 0:
            n //= 5
            ans += n
        return ans
# leetcode submit region end(Prohibit modification and deletion)
