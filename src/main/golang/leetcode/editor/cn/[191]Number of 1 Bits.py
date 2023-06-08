# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def hammingWeight(self, n: int) -> int:
        ans = 0
        while n:
            ans += 1
            n &= n - 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
