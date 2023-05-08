# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        ans = ""
        n = len(s)
        end = n - 1
        while s[end] == ' ': end -= 1
        for i in range(end, -1, -1):
            if s[i] == ' ':
                break
            ans += s[i]
        return len(ans)
# leetcode submit region end(Prohibit modification and deletion)
