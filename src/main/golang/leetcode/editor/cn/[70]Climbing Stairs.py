# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def climbStairs(self, n: int) -> int:
        n0, n1 = 0, 1
        for i in range(1, n + 1):
            n0, n1 = n1, n0 + n1
        return n1

# leetcode submit region end(Prohibit modification and deletion)
