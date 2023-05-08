# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        def mulByAdd(a: int, b: int):
            ans = 0
            while b > 0:
                if (b & 1) == 1: ans += a
                b >>= 1
                a += a
            return ans

        flag = False if divisor < 0 != dividend < 0 else True
        divisor, dividend = abs(divisor), abs(dividend)

        l, r = 0, dividend
        while l < r:
            mid = l + r + 1 >> 1
            if mulByAdd(mid, divisor) <= dividend:
                l = mid
            else:
                r = mid - 1
        r = r if flag else -r
        return max(-2 ** 31, min(r, 2 ** 31 - 1))
# leetcode submit region end(Prohibit modification and deletion)
