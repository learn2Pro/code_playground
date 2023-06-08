
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverseWords(self, s: str) -> str:
        words = s.strip().split(" ")
        return " ".join([word for word in reversed(words) if word])
# leetcode submit region end(Prohibit modification and deletion)
