
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        res = 0
        for c in columnTitle:
            res = res * 26 + ord(c) - ord('A') + 1
        return res
# leetcode submit region end(Prohibit modification and deletion)
