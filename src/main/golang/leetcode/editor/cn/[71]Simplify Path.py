# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        for word in path.split("/"):
            if word == '..':
                if stack:
                    stack.pop()
            elif word != '.' and word != '':
                stack.append(word)
        return "/" + "/".join(stack)
# leetcode submit region end(Prohibit modification and deletion)
