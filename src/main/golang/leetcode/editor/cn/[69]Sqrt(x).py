# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def mySqrt(self, x: int) -> int:
        l, r = 0, x
        while l < r:
            mid = (l + r + 1) >> 1
            if mid * mid <= x:
                l = mid
            else:
                r = mid - 1
        return l
# leetcode submit region end(Prohibit modification and deletion)
