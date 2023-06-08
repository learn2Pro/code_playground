# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        # return n & (n - 1) == 0 and n > 0
        big = 1 << 30
        return n > 0 and big % n == 0
# leetcode submit region end(Prohibit modification and deletion)
