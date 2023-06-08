
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for _ in range(32):
            res = (res << 1) + (n & 1)
            n >>= 1
        return res
        
# leetcode submit region end(Prohibit modification and deletion)
