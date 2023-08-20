# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        stack = []
        for i, c in enumerate(s):
            if c in stack:
                continue
            while stack and stack[-1] > c and stack[-1] in s[i:]:
                stack.pop()
            stack.append(c)
        return ''.join(stack)
# leetcode submit region end(Prohibit modification and deletion)
