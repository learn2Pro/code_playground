from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []

        def backtrack(curr: str, remain: int, put: int):
            if len(curr) == 2 * n:
                ans.append(curr)
                return
            if remain > 0:
                backtrack(curr + "(", remain - 1, put + 1)
            if put > 0:
                backtrack(curr + ")", remain, put - 1)

        backtrack("", n, 0)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
