
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countDigitOne(self, n: int) -> int:
        ans = 0
        i = 1
        while i <= n:
            divider = i * 10
            ans += (n // divider) * i + min(max(n % divider - i + 1, 0), i)
            i *= 10
        return ans
# leetcode submit region end(Prohibit modification and deletion)
