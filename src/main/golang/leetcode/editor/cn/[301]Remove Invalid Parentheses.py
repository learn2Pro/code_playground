import collections
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def is_valid(s):
            cnt = 0
            for c in s:
                if c == '(':
                    cnt += 1
                elif c == ')':
                    if cnt > 0:
                        cnt -= 1
                    else:
                        return False
            return cnt == 0

        ans = []
        curr_q = {s}
        while curr_q:
            next_q = set()
            for curr in curr_q:
                if is_valid(curr):
                    ans.append(curr)
                if ans:
                    continue
                for i in range(len(curr)):
                    if i > 0 and curr[i] == curr[i - 1]:
                        continue
                    if curr[i] in '()':
                        next_q.add(curr[:i] + curr[i + 1:])
            curr_q = next_q
        return ans
        # def is_valid(s):
        #     cnt = 0
        #     for c in s:
        #         if c == '(':
        #             cnt += 1
        #         elif c == ')':
        #             cnt -= 1
        #             if cnt < 0:
        #                 return False
        #     return cnt == 0
        # def dfs(s, start, l, r):
        #     if l == 0 and r == 0:
        #         if is_valid(s):
        #             res.append(s)
        #         return
        #     for i in range(start, len(s)):
        #         if i > start and s[i] == s[i - 1]:
        #             continue
        #         if s[i] == '(' and l > 0:
        #             dfs(s[:i] + s[i + 1:], i, l - 1, r)
        #         if s[i] == ')' and r > 0:
        #             dfs(s[:i] + s[i + 1:], i, l, r - 1)
        # res = []
        # l_remove = r_remove = 0
        # for c in s:
        #     if c == '(':
        #         l_remove += 1
        #     elif c == ')':
        #         if l_remove > 0:
        #             l_remove -= 1
        #         else:
        #             r_remove += 1
        # dfs(s, 0, l_remove, r_remove)
        # return res

# leetcode submit region end(Prohibit modification and deletion)
