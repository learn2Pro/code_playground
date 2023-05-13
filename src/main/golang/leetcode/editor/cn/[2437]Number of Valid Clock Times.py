
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countTime(self, time: str) -> int:
        h, m = time.split(':')
        return int(h) * 60 + int(m)
# leetcode submit region end(Prohibit modification and deletion)
