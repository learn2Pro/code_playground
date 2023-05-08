# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    # def reverse(self, x: int) -> int:
    #     flag = -1 if x < 0 else 1
    #     res = flag * int(str(abs(x))[::-1])
    #     return res if res > -2 ** 31 and res < 2 ** 31 - 1 else 0
    def reverse(self, x: int) -> int:
        flag = -1 if x < 0 else 1
        res, x = 0, x * flag
        while x != 0:
            res = res * 10 + x % 10
            x //= 10
        res *= flag
        return res if -2 ** 31 < res < 2 ** 31 - 1 else 0

# leetcode submit region end(Prohibit modification and deletion)
