
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        shift = 0
        while left < right:
            left >>= 1
            right >>= 1
            shift += 1
        return left << shift
# leetcode submit region end(Prohibit modification and deletion)
