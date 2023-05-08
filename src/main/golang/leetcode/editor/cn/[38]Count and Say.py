# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        mid = self.countAndSay(n - 1)
        previous, ans = "", ""
        counter = 0
        for c in mid:
            if c == previous:
                counter += 1
            else:
                ans += ("" if counter == 0 else str(counter)) + previous
                previous, counter = c, 1
        if counter != 0:
            ans += str(counter) + previous
        return ans

# leetcode submit region end(Prohibit modification and deletion)
