# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows <= 1: return s
        lst = ["" for _ in range(numRows)]
        curr, direction = 0, -1
        for c in s:
            lst[curr] += c
            if curr == 0 or curr == numRows - 1: direction = -direction
            curr += direction
        return "".join(lst)
# leetcode submit region end(Prohibit modification and deletion)
