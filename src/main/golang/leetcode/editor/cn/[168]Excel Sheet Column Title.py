# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        res = []
        while columnNumber > 0:
            columnNumber -= 1
            res.append(chr(columnNumber % 26 + ord('A')))
            columnNumber //= 26
        return ''.join(res[::-1])
# leetcode submit region end(Prohibit modification and deletion)
