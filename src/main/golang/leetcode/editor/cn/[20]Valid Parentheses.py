# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = ['?']
        dic = {'(': ')', '[': ']', '{': '}', '?': '?'}
        for c in s:
            if c in dic:
                stack.append(c)
            elif dic[stack.pop()] != c:
                return False
        return len(stack) == 1

# leetcode submit region end(Prohibit modification and deletion)
