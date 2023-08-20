#
# @lc app=leetcode id=22 lang=python3
#
# [22] Generate Parentheses
#
from typing import List
# @lc code=start


class Solution:
    def __init__(self) -> None:
        self.ans = {}
        for i in range(1, 9):
            self.ans[i] = self.generateParenthesis0(i)

    def generateParenthesis0(self, n: int) -> List[str]:
        l, r = 0, 0
        ans = []

        def backtrack(l: int, r: int, cur: str):
            if l == r == 0:
                ans.append(cur)
                return
            if l > 0:
                backtrack(l-1, r, cur+'(')
            if r > 0 and r > l:
                backtrack(l, r-1, cur+')')

        backtrack(n, n, '')
        return ans

    def generateParenthesis(self, n: int) -> List[str]:
        return self.ans[n]


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.ans[1])
    print(s.ans[2])
    print(s.ans[3])
