# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ans = [1] * n
        i2 = i3 = i5 = 0
        for i in range(n - 1):
            u2, u3, u5 = 2 * ans[i2], 3 * ans[i3], 5 * ans[i5]
            u = min(u2, u3, u5)
            if u == u2:
                i2 += 1
            if u == u3:
                i3 += 1
            if u == u5:
                i5 += 1
            ans[i + 1] = u
        return ans[-1]
# leetcode submit region end(Prohibit modification and deletion)
