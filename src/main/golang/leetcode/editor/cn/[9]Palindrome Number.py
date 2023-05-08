# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        res = 0
        tmp = x
        while tmp > 0:
            res = res * 10 + tmp % 10
            tmp //= 10
        return res == x

# leetcode submit region end(Prohibit modification and deletion)
