# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        stack = []
        for node in preorder.split(','):
            stack.append(node)
            while len(stack) >= 3 and stack[-1] == '#' and stack[-2] == '#' and stack[-3] != '#':
                stack.pop()
                stack.pop()
                stack.pop()
                stack.append('#')
        return len(stack) == 1 and stack[-1] == '#'

# leetcode submit region end(Prohibit modification and deletion)
