# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # return pow(x, n)
        def pow0(x: float, n: int):
            if n == 0:
                return 1.0
            y = pow0(x, n // 2)
            return y * y if n % 2 == 0 else y * y * x

        return 1 / pow0(x, -n) if n < 0 else pow0(x, n)
# leetcode submit region end(Prohibit modification and deletion)
