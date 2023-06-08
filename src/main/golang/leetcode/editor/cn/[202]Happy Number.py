
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isHappy(self, n: int) -> bool:
        def get_next(n):
            res = 0
            while n > 0:
                n, digit = divmod(n, 10)
                res += digit ** 2
            return res

        seen = set()
        while n != 1 and n not in seen:
            seen.add(n)
            n = get_next(n)
        return n == 1
# leetcode submit region end(Prohibit modification and deletion)
