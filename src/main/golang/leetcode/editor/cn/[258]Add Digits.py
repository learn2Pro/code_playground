
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def addDigits(self, num: int) -> int:
        while num >= 10:
            num = sum(map(int, str(num)))
        return num
# leetcode submit region end(Prohibit modification and deletion)
