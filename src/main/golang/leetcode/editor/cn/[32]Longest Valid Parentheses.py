# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    # def longestValidParentheses(self, s: str) -> int:
    #     n = len(s)
    #     dp = [0] * n
    #     ans = 0
    #     for i in range(1, n):
    #         if s[i] == ')':
    #             if s[i - 1] == '(':
    #                 dp[i] = (dp[i - 2] if i >= 2 else 0) + 2
    #             elif i > dp[i - 1] and s[i - dp[i - 1] - 1] == '(':
    #                 dp[i] = dp[i - 1] + (dp[i - dp[i - 1] - 2] if i - dp[i - 1] >= 2 else 0) + 2
    #         ans = max(ans, dp[i])
    #
    #     print(dp)
    #     return ans
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        ans = 0
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    ans = max(ans, i - stack[-1])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
